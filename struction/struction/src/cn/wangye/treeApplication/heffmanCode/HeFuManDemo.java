package cn.wangye.treeApplication.heffmanCode;

import java.io.*;
import java.util.*;

/*目前存在一个问题，我的解码依赖于第一次压缩的长度，这个是比较不合理的。
 * 其他解决：在压缩结构后+一个空格，作为压缩的冗余;
 *
 * */
public class HeFuManDemo {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws ClassNotFoundException {
        //这是压缩文件
        String srcFile = "C:\\Users\\wang'ye\\OneDrive\\图片\\屏幕快照\\泰姬陵.png";
        String dstFile = "E:/text/泰姬陵.zip";
        zipFile(srcFile,dstFile);
        System.out.println("压缩成功");
//        解压文件
        String srcFile1 = "E:/text/泰姬陵.zip";
        String dstFile1 = "E:/text/taiJiLandscape.png";
        unZipFile(srcFile1, dstFile1);
        System.out.println("解压成功");


//        String content = "i like like like java do you like a java";
//        byte[] bytes = content.getBytes();
//        huffmanZip(bytes);
  /*      String content = "i like like like java do you like a java";
        byte[] byteCodes = zip(content);//返回一个这样的数组:[-88, -65, -56, -65, -56, 28]
        String decodeCodes = decode(byteCodes, huffmanCodes);
        System.out.println(decodeCodes);*/
    }


    public static void unZipFile(String srcFile, String dstFile) throws ClassNotFoundException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(dstFile);

            byte[] huffmanBytes = (byte[]) objectInputStream.readObject();

            Map<Byte, String> huffmanCodes = (Map<Byte, String>) objectInputStream.readObject();
            byte[] b = decode(huffmanBytes, huffmanCodes);

            fileOutputStream.write(b);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


    /**
     * 文件压缩功能
     *
     * @param srcFile 压缩文件的路径
     * @param dstFile 压缩后的文件存放路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);//创建一个和文件输出流相关联的ObjectOutputStream;
            oos.writeObject(huffmanBytes);//把文件压缩出来的huffmanBytes写入文件中
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                oos.close();
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 赫夫曼文件压缩，
     *
     * @param bytes byte[]类型的数据；
     * @return 赫夫曼编码完成后的数据；
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> list = createList(bytes);
        Node root = createHuffmanTree(list);
        //这里实际上就是遍历了这个huffman树，并取出了每一个节点的值，将其存入了Map<Byte, String> huffmanCodes
        getCodes(root, "", new StringBuilder());
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }


    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
//        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));//强呀！！！
        }
        /*
         * 这种压缩没有体现出数字的优势，需要进一步地进行压缩操作;
         * 现在这样的文件压缩成了01010101001001010的格式，我们可以通过二进制的转化成一个数字，其中第一位表示符号位
         * 现在进行二进制压缩，将8个字符作为一个byte，（补码-》反码-》原码）
         * */
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);//直接截取到最后一位，不够的话，会自动用0补齐八位。
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
//            将strByte转成一个byte,放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);//将其转化成int类型的数据，挺强大的。
            index++;
        }
        return huffmanCodeBytes;
    }


    //    这里根据我们的哈夫曼编码去进行解码的操作，获取原来的字符串。
    /*
     * 困难点:
     * 1.对于二进制字符串扫描长度的确定
     * 拿着map中的value去获取key.
     * */
//    配对结果，这是一长串的01010110的字符串
//    我手上的钥匙有map     key-value:字母-路径 32-01 我需要从value来获取key
    public static byte[] decode(byte[] byteCodes, Map<Byte, String> codes) {
        //      将byteCodes进行转化，byte[] ->010010101 ->String
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < byteCodes.length; i++) {
            boolean flag = (i == byteCodes.length - 1);
            byte b = byteCodes[i];
            stringBuilder1.append(byteToBitString(!flag, b, stringBuilder1.length()));
        }

//        将map的内容进行反转;
        Map<String, Byte> newCodes = new HashMap<>();
        //学会了如何使用forEach进行map集合的遍历
        codes.forEach((key, value) -> {
            newCodes.put(value, key);
        });

//
//      创建一个list集合,存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder1.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while(flag){
                String key = stringBuilder1.substring(i,i+count);
                b = newCodes.get(key);
                if (b==null){
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0 ;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;

      /*  String str = "";
        String letter = "";
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            letter += str.charAt(i);
            Byte by = newCodes.get(letter);
            if (by != null) {
                newString += (char) (int) by;
                letter = "";
            }
        }
        System.out.println(newString);
        return newString;
        */
    }


    /**
     * 这一个一个将byte数组的数，转化成二进制的方法;
     *
     * @param flag 判断是否需要进行补位操作，true补位，false不补位；所有的都需要补高位，进行截取，只有最后一个数字不需要补位操作。
     * @param b    一个byte类型的数
     * @return 有一个不懂，如果需要负数，不是应该直接进行截取吗？
     */
    public static String byteToBitString(boolean flag, byte b, int length) {
        int temp = b;
        if (flag) {//需要补高位，
            temp |= 256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if (flag) {//需要补高位
            return binaryString.substring(binaryString.length() - 8);
        } else {
            /*
             * 这里并不是直接返回，还需要判断是否需要进行补0的情况，不一定是补满八位
             * 这里有两种情况:一个是进行高位补0，一个是直接进行返回
             * 什么时候需要高位补0, 不一定补一个，是在高位补充多个零。
             * 为什么会出现需要补充0的情况:
             * 这里设计一个可以除尽，除不尽的问题 除以8
             * */
            int binLength = length + binaryString.length();
            if (stringBuilder.length() != binLength) {
                int subtract = stringBuilder.length() - binLength;
                for (int i = 0; i < subtract; i++) {
                    binaryString = "0" + binaryString;
                }
            }
            return binaryString;
        }
    }

    //这里我想要生成一个哈夫曼树每一个数据节点，对应的路径code
//    我需要遍历所有的节点，然后获取其路径
//    1.路径的存储的数据结构应该使用hashMap   Map<byte,String>
    static Map<Byte, String> huffmanCodes = new HashMap<>();//先执行静态代码块

//    这里写一个遍历哈夫曼树的方法，并记录路径，将找到的数据节点存储在map当中
//    如果想要遍历一棵树，那么一般是使用递归的，除非是线索化二叉树。

    /**
     * 功能：遍历哈夫曼树取出每一个叶子节点，哈夫曼树只要带叶子结点的就是我们需要的data不为null的节点。
     *
     * @param node          节点，本次遍历的节点
     * @param code          路径
     * @param stringBuilder
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);//通过这一个将之前的路径复制过来
        stringBuilder2.append(code);//在之前的路径后面进行新的拼接
        if (node != null) {
            if (node.data == null) {
                //向左进行递归；
                getCodes(node.left, "0", stringBuilder2);
                //向右进行递归；
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    public static List<Node> createList(byte[] bytes) {
        List<Node> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            if (map.get(b) == null) {
                map.put(b, 1);
            } else {
                int count = map.get(b);
                map.replace(b, count + 1);
            }
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Byte b = (Byte) it.next();
            Integer num = map.get(b);
            Node node = new Node(b, num);
            list.add(node);
        }
        return list;
    }

    /**
     * @param 'list' 传入一个字符串转化完成后的list,每一个list中的对象包含data和weight;
     * @return 所创建的哈夫曼树的根节点;
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node newNode = new Node(null, leftNode.weight + rightNode.weight);
            newNode.left = leftNode;
            newNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    public static void preOrder(Node node) {
        if (node != null) {
            node.preOrder();
        } else {
            System.out.println("抱歉该哈夫曼树为空");
        }
    }
}
