package 牛客初级._02其他;


import org.junit.Test;

import java.util.Stack;

/**
 *
 * 笑哭，写错了，写成堆了
 *
 实现一种狗猫队列的结构,
 要求如下: 用户可以调用add方法将cat类或dog类的实例放入队列中;
 用户可以调用pollAll方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
 用户可以调用pollDog方法,将队列中dog类的实例按照进队列的先后顺序依次弹出;
 用户可以调用pollCat方法,将队列中cat类的实例按照进队列的先后顺序依次弹出;
 用户可以调用isEmpty方法,检查队列中是否还有dog或cat的实例;
 用户可以调用isDogEmpty方法,检查队列中是否有dog类的实例;
 用户可以调用isCatEmpty方法,检查队列中是否有cat类的实例
 */


public class _17猫狗队列 {
    public class Pet {
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getPetType() {
            return this.type;
        }
    }
    public class Dog extends Pet {
        public Dog(int i) {
            super("dog"+i);
        }

        @Override
        public String toString() {
            return super.type;
        }
    }
    public class Cat extends Pet {
        public Cat(int i) {
            super("cat"+i);
        }
        @Override
        public String toString() {
            return super.type;
        }
    }


    public class PetStack{
        public Stack<Pet> ps;
        public PetStack(){
            ps=new Stack<Pet>();
        }
        public boolean isEmpty(){
            return ps.isEmpty();
        }
        public void add(Pet pet){
            ps.push(pet);
        }
        public void pullAll(){
            if(ps.empty()){
                return;
            }
            System.out.print("pullAll：");
            while(!ps.empty()){
                System.out.print(ps.pop()+" ");
            }
            System.out.println();
        }
        public void pollDogs(){
            if(ps.empty()){
                return;
            }
            Stack<Pet> help=new Stack<Pet>();
            System.out.print("pollDogs：");
            while(!ps.empty()){
                if(ps.peek().getPetType().contains("dog")){
                    System.out.print(ps.peek()+" ");
                    ps.pop();
                }else{
                    help.push(ps.pop());
                }
            }
            System.out.println();
            ps=daoStack(help);
        }

        public boolean isDogEmpty(){
            Stack<Pet> help=new Stack<Pet>();
            boolean empty=true;
            while(!ps.empty()){
                if(ps.peek().getPetType().contains("dog")){
                    empty=false;
                }
                help.push(ps.pop()); //全要放入help
            }
            ps=daoStack(help);
            return empty;
        }

        public Stack<Pet> daoStack(Stack<Pet> help){
            Stack<Pet> ps =new Stack<>();
            while(!help.empty()){
                ps.push(help.pop());
            }
            return ps;
        }


        @Override
        public String toString() {
            return "PetStack{" +
                    "ps=" + ps +
                    '}';
        }
    }


    @Test
    public void test(){
        PetStack petStack = new PetStack();
        Pet dog1=new Dog(1);
        Pet dog2=new Dog(2);
        Pet cat1=new Cat(1);
        Pet cat2=new Cat(2);
        System.out.println(cat2.getPetType().contains("cat"));

        petStack.add(dog1);
        petStack.add(cat1);
        petStack.add(dog2);
        petStack.add(cat2);
        System.out.println(petStack);
        System.out.println("isDogEmpty:"+petStack.isDogEmpty());

        petStack.pollDogs();

        System.out.println(petStack);
        System.out.println("isDogEmpty:"+petStack.isDogEmpty());

        petStack.pullAll();


    }
}
