public class SimpleList {

    private String[] items;
    private int size;
    private int index;

    public SimpleList(int capacity) {
        items = new String[capacity];
        size = 0;
        index = 0;
    }

    public void add(String item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        }
    }

    public SimpleListIterator createIterator() {
        return new iter(this);
    }

    public static class iter implements SimpleListIterator {
        private SimpleList list;
        private int currentIndex;

        public iter(SimpleList list) {
            this.list = list;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return list.items[currentIndex++];
            }
            return null;
        }
    }


    public static void main(String[] args) {
        SimpleList myList = new SimpleList(3);
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");

        // Using the iterator to traverse the collection
        SimpleListIterator iterator = myList.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
