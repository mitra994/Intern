
    public int[] getArrayOfMedian(int[] grades) {

        int[] container = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            container[i] = getMedian(Arrays.copyOfRange(grades, 0, i+1));
        }
        return container;
    }


    private int getMedian(int[] gradesPart) {
        Arrays.sort(gradesPart);
        int middle = gradesPart.length / 2;

        if (gradesPart.length%2==0) {
            return (gradesPart[middle-1] + gradesPart[middle] + 1) / 2;
        } else {
            return gradesPart[middle];
        }
    }

