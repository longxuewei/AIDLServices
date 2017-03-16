// BookManager.aidl
package cn.lxw.aidlservers;
// Declare any non-default types here with import statements
import cn.lxw.aidlservers.Book;
interface BookManager {

    List<Book> getBooks();

    void addBook(in Book b);
}
