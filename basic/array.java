class Array {
    public static void main(String[] argv){
        int[] arr1 = new int[5];
        int[] arr2 = {1, 2, 3, 4, 5};
        
        int length_of_arr1 = arr1.length;
        int length_of_arr2 = arr2.length;
        System.out.println("Length of arr1: " + length_of_arr1 + 
            "\nLength of arr2: " + length_of_arr2);

        int[][] tdarr1 = new int [5][5];
        int[][] tdarr2 = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        
        System.out.println("Length of tdarr1: " + tdarr1.length + 
            "\nLength of tdarr2: " + tdarr2.length);
    }
}

// Length of arr1: 5
// Length of arr2: 5
// Length of tdarr1: 5
// Length of tdarr2: 2