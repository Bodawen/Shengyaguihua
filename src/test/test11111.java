package test;

public class test11111 {
    public static void main(String arg[]){
        test11111 a = new test11111();
        a.t("1(2(3,4(,5),6(7,))");
    }

    private String t(String a){
        int vocab_number = 0;
        int left_number = 0;
        int right_number = 0;
        int coma_number = 0;

        char[] as = a.toCharArray();
        tree[] trees = new tree[as.length];
        for (char word :
                as) {
            System.out.println(word);
            if (word == '('){
                left_number++;
            }else if ( word != ')') {
                right_number++;
            }else if ( word!=','){
                coma_number++;
            }else{
                trees[vocab_number] = new tree(word);
                vocab_number++;
            }
        }

        return "";
    }

    class tree{
        char root;
        tree left;
        tree right;

        public tree(char root){
            this.root = root;
        }

        public tree getLeft() {
            return left;
        }

        public void setLeft(tree left) {
            this.left = left;
        }

        public tree getRight() {
            return right;
        }

        public void setRight(tree right) {
            this.right = right;
        }
    }
}
