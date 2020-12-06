package bai5_access_modifier.thuc_hanh.access_modifier.Default.mypack;
import bai5_access_modifier.thuc_hanh.access_modifier.Default.pack.*;
class B {
    public static void main(String args[]){

        A obj = new A();//Compile Time Error

        obj.msg();//Compile Time Error

    }

}
