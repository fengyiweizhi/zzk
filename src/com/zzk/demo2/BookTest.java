package com.zzk.demo2;

/**
 * 图书
 * @author 风亦未止
 */
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("爱的教育",11112);
        book.detail();
    }
}
class Book{
   private String title;
   private int pageNum=200;

    public Book(String title, int pageNum) {
        this.title = title;
        this.pageNum = pageNum;
    }

    public Book(String title) {
        this.title = title;
    }

    public void detail(){
        if(pageNum<200){
            System.out.println("页码错误");
            return;
        }
        System.out.println("书名："+title+" "+"页码数"+pageNum);
    }

}