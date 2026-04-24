package algorithms.circularlinkedlist;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

    public String toString(){
      String result = "" + value;
        if (next != null){
            result += " -> " + next.toString();
        }
        return result;
    }
}

// toString virker fint til normale lister
// MEN vil give StackOverflowError hvis der er en cyklus,
// fordi den kalder sig selv uendeligt
