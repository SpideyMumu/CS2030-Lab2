import java.util.List;

class Grid2D {
    private final ImList<Integer> list;
    private final int numOfCols;
    
    Grid2D(List<Integer> list, int numOfCols) {
        this.list = new ImList<Integer>(list);
        this.numOfCols = numOfCols;
    }


    Grid2D(int numOfCols) {
        this(List.of(), numOfCols);
    }

    private Grid2D(ImList<Integer> list, int numOfCols) {
        this.list = list;
        this.numOfCols = numOfCols;
    }

    Grid2D add(int elem) {
        return new Grid2D(this.list.add(elem), numOfCols);
    }

    int get(int r, int c) {
        return this.list.get(numOfCols * r + c);
    }

    Grid2D set(int r, int c, int elem) {
        return new Grid2D(this.list.set((numOfCols * r + c), elem), this.numOfCols); 
    }

    public String toString() {
        String output = "{";
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            output += list.get(i);
            
            if (i == list.size() - 1) {
                break;
            } else if (count < numOfCols) {
                output += ",";
                count++;
            } else {
                output += ";";
                count = 1;
            }
        }
        return output + "}";
    }
}
