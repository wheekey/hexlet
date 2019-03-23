package xo;

class ArrayList implements IList {
    // BEGIN (write your solution here)
    private Object[] list = new Object[100];
    private int size = 0;
    // END

    public synchronized void add(final Object element) {
        // BEGIN (write your solution here)
        list[size] = element;

        size++;

        if(size % 100 == 0)
        {
            Object[] newList = new Object[size+100];

            for (int i =0 ; i< size; i ++)
            {
                newList[i] = list[i];
            }
            list = newList;
        }
        // END
    }

    public synchronized void removeLast() {
        // BEGIN (write your solution here)
        if(size > 0)
        {
            this.list[size - 1] = null;
            size--;
        }

        // END
    }

    public int size() {
        // BEGIN (write your solution here)
        return size;
        // END
    }

    public Object get(final int index) {
        // BEGIN (write your solution here)

        if(index < size && index >= 0 )
        {
            return this.list[index];
        }
        return null;
        // END
    }

    public synchronized void set(final int index, final Object object) {
        // BEGIN (write your solution here)
        this.list[index] = object;
        // END
    }
}