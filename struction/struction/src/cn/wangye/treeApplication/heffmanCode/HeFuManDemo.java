package cn.wangye.treeApplication.heffmanCode;

import java.util.*;
/*目前存在一个问题，我的解码依赖于第一次压缩的长度，这个是比较不合理的。
* 其他解决：在压缩结构后+一个空格，作为压缩的冗余;
*
* */
public class HeFuManDemo {
    static String newStr = "";

    public static void main(String[] args) {

//        String content = "world world i like like like java do you like a java hello world";
        String content = "world world i like like like java do you like a java hello";
//        String content = "world world i like like like java do you like a java";

        byte[] byteCodes = zip(content);//返回一个这样的数组:[-88, -65, -56, -65, -56, 28]
        String decodeCodes = decode(byteCodes, codes);
        System.out.println(decodeCodes);
    }

    public static byte[] zip(String content) {
        byte[] bytes = content.getBytes();  //将字符串转化成一个byte类型的数组，即字符串中字符对应的ASCII编码;
        List<Node> list = createList(bytes);
        Node root = createHuffmanTree(list);
        getCodes(root, "", new StringBuilder());
        for (int i = 0; i < content.length(); i++) {
            Byte findValue = (byte) content.charAt(i);
            newStr += codes.get(findValue);//通过赫夫曼树编译成101010011001的长字符串。
        }
        System.out.println(newStr);
        System.out.println(newStr.length());

        /*
         * 这种压缩没有体现出数字的优势，需要进一步地进行压缩操作;
         * 现在这样的文件压缩成了01010101001001010的格式，我们可以通过二进制的转化成一个数字，其中第一位表示符号位
         * 现在进行二进制压缩，将8个字符作为一个byte，（补码-》反码-》原码）
         * */
        int len;
        if (newStr.length() % 8 == 0) {
            len = newStr.length() / 8;
        } else {
            len = newStr.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < newStr.length(); i += 8) {
            String strByte;
            if (i + 8 > newStr.length()) {
                strByte = newStr.substring(i);//直接截取到最后一位，不够的话，会自动用0补齐八位。
            } else {
                strByte = newStr.substring(i, i + 8);
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
    public static String decode(byte[] byteCodes, Map<Byte, String> codes) {
//        将map的内容进行反转;
        Map<String, Byte> newCodes = new HashMap<>();
        //学会了如何使用forEach进行map集合的遍历
        codes.forEach((key, value) -> {
            newCodes.put(value, key);
        });

        String str = "";
        String letter = "";
        String newString = "";

//      将byteCodes进行转化，byte[] ->010010101 ->String
        for (int i = 0; i < byteCodes.length; i++) {
            boolean flag = (i == byteCodes.length - 1);
            byte b = byteCodes[i];
            str += byteToBitString(!flag, b, str.length());
        }
        System.out.println(str);
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            letter += str.charAt(i);
            Byte by = newCodes.get(letter);
            if (by != null) {
                newString += (char) (int) by;
                letter = "";
            }
        }
        return newString;
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
            System.out.println("最后一个长度" + binLength);
            if (newStr.length() != binLength) {
                int subtract = newStr.length() - binLength;
                for (int i = 0; i < subtract; i++) {
                    binaryString = "0"+binaryString;
                }
            }
            return binaryString;
        }
    }

    //这里我想要生成一个哈夫曼树每一个数据节点，对应的路径code
//    我需要遍历所有的节点，然后获取其路径
//    1.路径的存储的数据结构应该使用hashMap   Map<byte,String>
    static Map<Byte, String> codes = new HashMap<>();//先执行静态代码块

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
                codes.put(node.data, stringBuilder2.toString());
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
