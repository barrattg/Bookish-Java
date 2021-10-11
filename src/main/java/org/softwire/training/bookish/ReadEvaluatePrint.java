package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class ReadEvaluatePrint {

    public static void Loop(Jdbi jdbi) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("View available commands with 'help'");

            while (true) {

                System.out.print(">>> ");
                String rawInput = scanner.nextLine();
                String[] input = rawInput.split(" ", 2);

                if (input.length == 1) input = new String[]{input[0], ""};

                try {
                    Class<?> commandClass = Class.forName("org.softwire.training.bookish.commands." + input[0]);
                    Object commandInstance = commandClass.newInstance();
                    Method m = commandClass.getDeclaredMethod("Execute", String.class, Jdbi.class);
                    m.invoke(commandInstance, rawInput, jdbi);

                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println("Invalid command, type 'Help' to see available commands  :)");
                }
            }

    }

}
