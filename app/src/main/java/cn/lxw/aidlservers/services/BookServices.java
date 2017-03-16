package cn.lxw.aidlservers.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.lxw.aidlservers.Book;
import cn.lxw.aidlservers.BookManager;

/**
 * 源代码: Lxw
 * 伊妹儿: China2021@126.com
 * 时间轴: 2017 年 03 月 15 日 17 : 44
 */

public class BookServices extends Service {

    private static final String TAG = "BookServices";
    private List<Book> books = new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return manager;
    }

    private BookManager.Stub manager = new BookManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            Log.i(TAG, "getBooks: 获取所有图书!");
            return books;
        }

        @Override
        public void addBook(Book b) throws RemoteException {
            if (b == null)
                return;
            Log.i(TAG, "addBook: 添加图书," + b.toString());
            books.add(b);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book("金瓶梅", 1);
        books.add(book);
    }
}
