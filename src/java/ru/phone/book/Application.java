package ru.phone.book;

import ru.phone.book.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    private static List<Contact> contacts = new ArrayList<>(10);
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Список команд:");
            System.out.println("1. Новый контакт");
            System.out.println("2. Редактировать контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Выйти");
            System.out.println("Выведите номер команды:");
            Scanner console = new Scanner(System.in);
            int commandNumber = console.nextInt();

            switch (commandNumber) {
                case 1:
                    addContact();
                    printContacts();
                    break;
                case 2:
                    editContact();
                    printContacts();
                    break;
                case 3:
                    deleteContact();
                    printContacts();
                    break;
                case 4:
                    printContacts();
                    return;
            }
        }
    }

    private static void addContact() {
        System.out.println("Создание контакта...");
        System.out.println("Введите имя:");
        String name = console.nextLine();
        if (name.isEmpty()) {
            System.out.println("Нельзя оставить поле пустым!!!");
            return;
        }
        System.out.println("Введите номер:");
        String number = console.nextLine();
        if (number.isEmpty()) {
            System.out.println("Нельзя оставить поле пустым!!!");
            return;
        }
        Contact contact = new Contact();
        contact.setName(name);
        contact.setValue(number);
        contacts.add(contact);
    }

    private static void editContact() {
        System.out.println("Редактирование контактов...");
        System.out.println("Введите индекс контакта:");
        int index = console.nextInt();
        Contact contact = contacts.get(index - 1);
        System.out.println("Введите имя:");
        String name = console.nextLine();
        if (name.isEmpty()) {
            System.out.println("Нельзя оставить поле пустым!!!");
            return;
        }
        name = console.nextLine();
        System.out.println("Введите номер:");
        String number = console.nextLine();
        if (number.isEmpty()) {
            System.out.println("Нельзя оставить поле пустым!!!");
            return;
        }
        contact.setName(name);
        contact.setValue(number);
    }

    private static void deleteContact() {
        System.out.println("Удаление контактов...");
        System.out.println("Введите индекс контакта:");
        int index = console.nextInt();
        Contact contact = contacts.remove(index - 1);
    }

    private static void printContacts() {
        System.out.println("Список контактов:");
        for (int i = 1; i <= 10; i++) {
            if (i <= contacts.size()) {
                Contact contact = contacts.get(i - 1);
                System.out.println(i + ". " + contact.getName() + " " + contact.getValue());
            } else {
                System.out.println(i + ". ...");
            }
        }
    }
}
