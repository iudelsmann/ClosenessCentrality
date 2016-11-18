package main;

import java.util.Arrays;
import java.util.Collections;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

import algorithm.ClosenessCentrality;
import models.FacebookGraph;
import models.NamePair;

public class MainClass {

  public static void main(String[] args) {

    // TODO dynamically get the number of vertexes
    // final Graph g = new Graph(100, false);
    //
    // final Scanner scanner = new Scanner(System.in);
    //
    // // Reads until EOF or invalid token
    // while (scanner.hasNextInt()) {
    // int from = scanner.nextInt();
    // int to = scanner.nextInt();
    //
    // g.addEdge(from, to, 1);
    // }
    //
    // scanner.close();
    // // Executes the closeness centrality algorithm
    // Double[] result = ClosenessCentrality.calculate(g);
    //
    // // Builds pairs from the results, where index is the vertex number and
    // the
    // // value is the closeness of that vertex
    // Pair[] pairs = new Pair[g.getSize()];
    //
    // for (int i = 0; i < g.getSize(); i++) {
    // pairs[i] = new Pair(i, result[i]);
    // }
    //
    // // Sort the pairs and print out both the vertex and its closeness
    // Arrays.sort(pairs, Collections.reverseOrder());
    // for (int i = 0; i < g.getSize(); i++) {
    // System.out.format("%d %.10f\n", pairs[i].getIndex(),
    // pairs[i].getValue());
    // }

    // Access tokens for the tests users created
    String[] TOKENS = {
        "EAAXBMhNn08EBAKWDhzqbroHfZBfMU2Va7Pw1HIR0ay09JJZBllUCE8OrZAGLrZCsKKzGTkvW6bJBZAc2UgiOosmXyiqt72O2QSy5ChoEXJATZA62fZCzSupUbsHygbS8aiF9frlL6TsGFjT0dyZAz91yJlth9mgVHwdWpQqskP6Jg9ZAB5OrZAKFra",
        "EAAXBMhNn08EBANbG8HsERZCwgYIZA40dFUp7DDuxLLb9Q5ypi5rLYANKq0SnnFai0siUZAaSVfjxic4evW8rCXhWe44c044VyTUZBSTreohALZCLr4x2yo3gh9JhtghgbhvJZCceen6G0qO80OAG3BOugR9TsUwUNtirAlx0VtqQ5IOTHepJrZA",
        "EAAXBMhNn08EBAJvtgR9keo9cHp5CktaWOfuq5iXYtW1DzCZCL1zePNJ8MUYPCZCIg8H5QYIaikh9oOqC0EjefuwUgPEcXrkTpvGyiMGmQhZAP9dbjqhji6uZCP6CSc0HYb2fgI4k0kaWugWOCZAVrLBpvtZBiA5nr0wZC7e3GLOMevQ4Al3yNAk",
        "EAAXBMhNn08EBAKyjqWToY5GUTnavrFIe7x0Pbg8xFbzhRXQnIQJTbKgasHo9mNvgi0loiMVdrtw0KDic93JIhxE7nu0ZCIqutB9FItxZAnqEINCA3p0nNVnVNt9yQtYgybOUP2NsZCD7Bfz4SMZAIVhXZAMJfr4OJS6JqYBdbZB5PQrDxKjab5",
        "EAAXBMhNn08EBAF4BUEuWjDZACSkcOBaYybpP07L3dU3MqKr8r8qiTCqvYfxdkyUYgK0zOB5ZAi2KURRND3br9XtyRZCAmSiLt3QY2ipVP5jqFvCu1bBgXEXDJ8cRGWCikQPyqtpY9WYZA23OBlsOIpDZCfXUCwfr5DLGCZBMDZBCOfXPxjJAoKH",
        "EAAXBMhNn08EBAMd0Up1No2TYKxgWJjiDsAGwqD3ZA0mU6kbE6XGAcjeiJjezseU7IyagHHUe3eFZCMDs7j8VAKiFaWnr1Rvg58NJ19I71Ja0FgtgtXKqXBrKgoNvkfSK8FLEVew1XeUTDjq4F1EGD2PLIB5MWzsVJQQnFARDUXYTxjDYMz",
        "EAAXBMhNn08EBACVU2bOQXYFyUIuZAmp0BLY4kxGqLZA4j10F2jYZAzXdhPFDZA9pnZCj6MhQUD0AwNaA6IJmQY0ruSPQAJP5cqM00jIOrCux1J4c4Uf5XYZBKs8O92ZCLjzZCGvSCUFiWlDUyX6rOZApm88nit6m1maXNE9TaIYHCU9dUDZAuj62GB",
        "EAAXBMhNn08EBAGvi4yZA7q48OUrdOo5P0R8qt13f9I07nxelr5ZANfCzugWztt8MoaW1fPQiqFUZANcsUugznKdA7PUr3sZBz7P2iAm8cBZCZBKh5UPRsQ9Fj7tsJ8rharkYFFg2eZAzvzAyv8wmClrq6vOz8QRUCt5Vvk9FANgJniIu6yFsiTc",
        "EAAXBMhNn08EBAOPFn8l3SVXO5VAamu5CnipLJzRRcHJE7kZAjrVQCOYBNQFTFRJE9d56cHmLI1YgzAasmy3ZBgUYFMEwVQM5DNmn8ZBMIL2zCb1c4IB02WJnBzLCLmGYo3oeHOZBupdQ7YueS9kLMefNNS5gzQWUi66TWcwqfQEWAibwiQC8" };

    // Creates a graph for the users
    FacebookGraph g = new FacebookGraph(TOKENS.length);

    // Iterates fetching friends for
    for (String token : TOKENS) {
      FacebookClient facebookClient = new DefaultFacebookClient(token, Version.VERSION_2_8);

      User user = facebookClient.fetchObject("me", User.class);

      System.out.format("Fetching data from user %s\n", user.getName());
      Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);

      for (User friend : myFriends.getData()) {
        g.addFriendShip(user.getName(), friend.getName());
      }
    }

    Double[] result = ClosenessCentrality.calculate(g);

    NamePair[] pairs = new NamePair[result.length];
    for (int i = 0; i < result.length; i++) {
      pairs[i] = new NamePair(g.getNameFromIndex(i), result[i]);
    }

    Arrays.sort(pairs, Collections.reverseOrder());

    System.out.println();
    for (int i = 0; i < result.length; i++) {
      System.out.print(pairs[i].getName() + "\t\t");
      System.out.println(pairs[i].getValue());
    }
  }
}
