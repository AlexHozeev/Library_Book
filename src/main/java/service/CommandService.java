package service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Book;
import model.Library;

import java.util.Scanner;
import java.util.function.Consumer;

public class CommandService {

    private static final Library lib;
    private static final LibSerializer libSerializer = new LibSerializer(new JsonMapper());

static
    {
        lib= libSerializer.getLib();
    }


    public Consumer<Scanner>getShowCommand(){
        return scanner -> lib.getBooks().forEach((k, v) -> System.out.println(v));
    }
    public Consumer<Scanner>getSaveCommand(){
        return  scanner -> libSerializer.saveLib(lib);
    }

    public Consumer<Scanner> getAddCommand(){
       return scanner -> {
            var bookBuilder = Book.builder();
            System.out.println("Name: ");
            bookBuilder.name(scanner.nextLine());
            System.out.println("Writer: ");
            bookBuilder.writer(scanner.nextLine());
            System.out.println("Description: ");
            bookBuilder.description(scanner.nextLine());
            System.out.println("Number of pages: ");
            Book book = bookBuilder.numberOfPages(scanner.nextInt()).build();

            lib.getBooks().put(book.getName(),book);
            System.out.println("\nbook added to library");
        };
    }
}
