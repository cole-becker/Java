/*
File Name:	SortingRoutines
Programmer:	Cole Becker
Date:		June 24 2024
Purpose:        To create a program that generates random numbers from -1000 to 1000 and sorts them using preferred
*               sorting algorithm and order.
*/
import java.util.Random; // import random and JoptionPane
import javax.swing.JOptionPane;

public class SortingRoutines extends javax.swing.JFrame {


    public SortingRoutines() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSort = new javax.swing.JButton();
        numberInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        sortbytxt = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        sortingalgorithmtxt = new javax.swing.JLabel();
        titletxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        originalOutput = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        sortedOutput = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Number Sorter");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sorted:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Original:");

        btnSort.setBackground(new java.awt.Color(255, 255, 255));
        btnSort.setForeground(new java.awt.Color(51, 51, 51));
        btnSort.setText("sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        numberInput.setBackground(new java.awt.Color(255, 255, 255));
        numberInput.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount of numbers to sort:");

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        sortbytxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sortbytxt.setForeground(new java.awt.Color(255, 255, 255));
        sortbytxt.setText("Sort By:");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selection", "Insertion", "Bubble", "Quick" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        sortingalgorithmtxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sortingalgorithmtxt.setForeground(new java.awt.Color(255, 255, 255));
        sortingalgorithmtxt.setText("Sorting Algorithms:");

        titletxt.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titletxt.setForeground(new java.awt.Color(255, 255, 255));
        titletxt.setText("Sorting Routines");

        originalOutput.setEditable(false);
        originalOutput.setBackground(new java.awt.Color(51, 51, 51));
        originalOutput.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(originalOutput);

        sortedOutput.setEditable(false);
        sortedOutput.setBackground(new java.awt.Color(51, 51, 51));
        sortedOutput.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(sortedOutput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sortingalgorithmtxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(sortbytxt)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(106, 106, 106))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(titletxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titletxt)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortbytxt)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(sortingalgorithmtxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int[] selectionSort(int[] A){ // create function selectionSort
        for (int i = 0; i < A.length-1; i++){ // start i at 0 and increment
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++){ // start j at i + 1 and increment
                if (A[minIndex] > A[j]){ // scan through elements in array for minimum number
                    minIndex = j; // sets minIndex to the lowest index of the number in array
                }
            }
            int temp = A[minIndex]; // set temp to lowest number
            A[minIndex] = A[i]; 
            A[i] = temp; // swap the lowest number to be in front of the rest
        }
        return A; // return sorted array
    }
    
    public int[] insertionSort(int [] A){
        for (int i = 1; i < A.length; i++){ // start i at 1 and increment
            int key = A[i]; // store value of that element at index i in variable key
            int j = i - 1; // variable j is the index of the element to the left of i in array
            while(j>=0 && key < A[j]){ // while j is greater or equal to 0 and the key is less than the integer at array index j
                A[j+1] = A[j]; // shift the value of the element to the right
                j--; // decrement j
            }
            A[j+1] = key; // when broken out of the loop key is set to the index in which the key is greater than or when j reaches -1 in the index
        }
        return A; // return sorted array
    }
    
    public int[] bubbleSort(int[] A){
        for(int i = 0; i < A.length - 1; i++){ // runs through array length - 1 amount of times
            for (int j=0; j<A.length - 1 - i; j++){ // doesn't need to go all the way to the right side of elements because it sorts to the right first
                if(A[j] > A[j+1]){ // if the left integer is greater then the right integer in the array
                    int temp = A[j+1]; // create temp to store value so they can swap
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A; // return sorted array after gone through i amount of times
    }
    
    public void quickSort(int[] A, int left, int right) { // sorts an array using the quicksort algorithm
        int index = partition(A, left, right); // partition array and get the pivot element
        
        if (left < index - 1){ // recursively sort the left subarray if there is more than one element
            quickSort(A, left, index - 1);
        }
        
        if (right > index){ // recursively sort the right subarray if there is more than one element
            quickSort(A, index, right);
        }
        
    }
    
    public int partition(int [] A, int left, int right){ // partitions the array such that elements smaller than the pivot are on the left and greater on the right
        int pivot = A[(right + left) / 2]; // create pivot (middle element)
        while (left <= right){
            while (A[left] < pivot) left++; // look for elements that should be on the right
            while (A[right] > pivot) right--; // look for elements that should be on the left
            
            if (left <= right) { // swap the elements found above
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++; // increments to move to next elements on both sides
                right--;
            }
        }
        return left; // return the index of pivot element 
    }
    
    public int[] descendingOrder(int[] A){
        int left = 0;
        int right = A.length - 1;
        while (left < right){ // runs loop until middle
            int temp = A[left]; // swap the values
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A; // returns reversed array
    }
    
    public void setText(int[] A){
        StringBuilder sortedStr = new StringBuilder(); // create stringbuilder for sorted output called sortedStr
        for (int i = 0; i < A.length; i++){
        sortedStr.append(A[i] + "\n"); // append all values of random number array
        }
        sortedOutput.setText(sortedStr.toString()); // set sorted output text to sortedStr
    }
    
    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        try {
            int n = Integer.parseInt(numberInput.getText()); // create variable n and takes the value from the Jtext
        int[] numbers = new int[n]; // creates array with n amount of elements
        Random random = new Random();
        for (int i = 0; i < n; i++){
            numbers[i] = random.nextInt(2001) - 1000; // adds n amount of random numbers to the array in range -1000 - 1000
        }
        
        StringBuilder originalStr = new StringBuilder(); // create stringbuilder for original output called originalStr
        for (int i = 0; i < numbers.length; i++){
            originalStr.append(numbers[i] + "\n"); // append all values of random number array
        }
        originalOutput.setText(originalStr.toString()); // set original output text to originalStr
        
        String selectedAlgorithm = jComboBox1.getSelectedItem().toString(); // takes selecteditems from comboboxs and stores strings in variables
        String selectedType = jComboBox2.getSelectedItem().toString();
        
        switch(selectedAlgorithm){ // switch case for jComboBox1 items
            case "Selection":
                if (selectedType.equals("Ascending")){ // if statements for if ascending is chosen in jComboBox2
                    selectionSort(numbers);
                    setText(numbers);
                } else { // descending chosen
                    selectionSort(numbers);
                    descendingOrder(numbers);
                    setText(numbers);
                }
                break;
            case "Insertion":
                if (selectedType.equals("Ascending")){
                    insertionSort(numbers);
                    setText(numbers);
                } else {
                    insertionSort(numbers);
                    descendingOrder(numbers);
                    setText(numbers);
                }
                break;
            case "Bubble":
                if (selectedType.equals("Ascending")){
                    bubbleSort(numbers);
                    setText(numbers);
                } else {
                    bubbleSort(numbers);
                    descendingOrder(numbers);
                    setText(numbers);
                }
                break;
            case "Quick":
                if (selectedType.equals("Ascending")){
                    quickSort(numbers, 0, numbers.length-1);
                    setText(numbers);
                } else {
                    quickSort(numbers, 0, numbers.length-1);
                    descendingOrder(numbers);
                    setText(numbers);
                }
                break;
        }
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"please enter a valid integer.");
        }
    }//GEN-LAST:event_btnSortActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jComboBox2ActionPerformed

    
    public static void main(String args[]) {
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingRoutines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSort;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField numberInput;
    private javax.swing.JTextPane originalOutput;
    private javax.swing.JLabel sortbytxt;
    private javax.swing.JTextPane sortedOutput;
    private javax.swing.JLabel sortingalgorithmtxt;
    private javax.swing.JLabel titletxt;
    // End of variables declaration//GEN-END:variables
}