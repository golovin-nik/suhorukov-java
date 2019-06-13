package com.jcourse.golovin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
}

interface BookKeeper {
    List<Book> getBookByAuthor(String author);
}

class BookKeeperImpl implements BookKeeper {
    @Override
    public List<Book> getBookByAuthor(String author) {
        try {
            //допустим, обращение к базе данных
            Thread.sleep(5000);
            return Arrays.asList(new Book(), new Book());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ProxyBookKeeper implements BookKeeper {

    private BookKeeper bookKeeper;
    private Map<String, List<Book>> bookCache = new HashMap<>();

    public ProxyBookKeeper(BookKeeper original) {
        this.bookKeeper = original;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> books = bookCache.get(author);
        if (books == null) {
            books = bookKeeper.getBookByAuthor(author);
        }
        return books;
    }
}

public class ProxyExample {

    public static void main(String[] args) {
        BookKeeper original = new BookKeeperImpl();
        BookKeeper proxy = new ProxyBookKeeper(original);
        Proxy.newProxyInstance(null, null, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = method.invoke(args);

                return result;
            }
        });
    }
}
