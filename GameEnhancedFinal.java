import java.util.Scanner;

/**
 * Kelas GameEnhancedFinal adalah game tanya jawab matematika sederhana untuk beberapa pemain.
 * Pemain harus menjawab beberapa pertanyaan matematika dalam berbagai tipe, dan skor akan
 * diberikan berdasarkan jawaban yang benar. Game juga menghitung waktu yang dibutuhkan
 * setiap pemain untuk menyelesaikan soal.
 */
public class GameEnhancedFinal {

    /**
     * Metode utama untuk menjalankan game.
     * @param args Argumen baris perintah yang tidak digunakan dalam metode ini.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfPlayers, noOfQuestions, num1, num2, answer, remainder, playerscore = 0, playertime, questionType, questionType1, index = 0;
        String playerTotalResult = "";
        long endTime, startTime;

        // Meminta jumlah pemain dari pengguna
        System.out.print("Masukkan jumlah pemain : ");
        noOfPlayers = scan.nextInt();
        // Memeriksa input untuk kesalahan
        noOfPlayers = Methods.checkForError(noOfPlayers, 1, "Masukkan jumlah pemain : ");

        // Mendeklarasikan array untuk menyimpan nama dan skor pemain
        int[] totalscore = new int[noOfPlayers * 2];
        String[] names = new String[noOfPlayers];

        // Meminta nama-nama pemain
        String enter = scan.nextLine();
        System.out.println("Masukkan nama pemain");
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Pemain no(" + (i + 1) + ") : ");
            names[i] = scan.nextLine();
        }

        // Meminta jumlah pertanyaan dari pengguna
        System.out.print("Masukkan jumlah pertanyaan : ");
        noOfQuestions = scan.nextInt();
        // Memeriksa input untuk kesalahan
        noOfQuestions = Methods.checkForError(noOfQuestions, 1, "Masukkan jumlah pertanyaan : ");

        // Meminta tipe pertanyaan dari pengguna
        questionType = Methods.getQuestionType();
        questionType1 = questionType;

        for (int i = 1; i <= noOfPlayers; i++) {
            System.out.println("\nPertanyaan untuk " + names[i - 1] + " :");
            Methods.delay();
            startTime = System.currentTimeMillis();
            for (int j = 1; j <= noOfQuestions; j++) {
                // Menghasilkan dua angka acak
                num1 = (int) (Math.random() * 10);
                num2 = (int) (Math.random() * 10);

                // Menukar angka jika num1 < num2
                if (num1 < num2) {
                    num1 = num1 + num2;
                    num2 = num1 - num2;
                    num1 = num1 - num2;
                }

                // Mengubah tipe pertanyaan menjadi acak jika dipilih random
                if (questionType1 == 5) {
                    questionType = (int) (1 + Math.random() * 4);
                }

                // Menentukan tipe pertanyaan berdasarkan pilihan pengguna
                switch (questionType) {
                    case 1:  // Pertanyaan penjumlahan
                        System.out.print(num1 + " + " + num2 + " = ");
                        answer = scan.nextInt();
                        if (answer == (num1 + num2)) {
                            System.out.println("Benar!");
                            playerscore++;
                            playerTotalResult = (playerTotalResult + num1 + " + " + num2 + " = " + answer + " Benar$");
                        } else {
                            System.out.println("Salah!");
                            System.out.println(num1 + " + " + num2 + " seharusnya = " + (num1 + num2));
                            playerTotalResult = (playerTotalResult + num1 + " + " + num2 + " = " + answer + " Salah$");
                        }
                        break;

                    case 2:  // Pertanyaan pengurangan
                        System.out.print(num1 + " - " + num2 + " = ");
                        answer = scan.nextInt();
                        if (answer == (num1 - num2)) {
                            System.out.println("Benar!");
                            playerscore++;
                            playerTotalResult = (playerTotalResult + num1 + " - " + num2 + " = " + answer + " Benar$");
                        } else {
                            System.out.println("Salah!");
                            System.out.println(num1 + " - " + num2 + " seharusnya = " + (num1 - num2));
                            playerTotalResult = (playerTotalResult + num1 + " - " + num2 + " = " + answer + " Salah$");
                        }
                        break;

                    case 3:  // Pertanyaan perkalian
                        System.out.print(num1 + " * " + num2 + " = ");
                        answer = scan.nextInt();
                        if (answer == (num1 * num2)) {
                            System.out.println("Benar!");
                            playerscore++;
                            playerTotalResult = (playerTotalResult + num1 + " * " + num2 + " = " + answer + " Benar$");
                        } else {
                            System.out.println("Salah!");
                            System.out.println(num1 + " * " + num2 + " seharusnya = " + (num1 * num2));
                            playerTotalResult = (playerTotalResult + num1 + " * " + num2 + " = " + answer + " Salah$");
                        }
                        break;

                    case 4:  // Pertanyaan pembagian
                        if (num2 == 0) {
                            num2 = (int) (1 + Math.random() * (num1));
                        }
                        System.out.print(num1 + " / " + num2 + " = ");
                        answer = scan.nextInt();
                        remainder = scan.nextInt();
                        if (answer == (num1 / num2) && remainder == (num1 % num2)) {
                            System.out.println("Benar!");
                            playerscore++;
                            playerTotalResult = (playerTotalResult + num1 + " / " + num2 + " = " + answer + " Sisa " + remainder + " Benar$");
                        } else {
                            System.out.println("Salah!");
                            System.out.println(num1 + " / " + num2 + " seharusnya = " + (num1 / num2) + " Sisa " + (num1 % num2));
                            playerTotalResult = (playerTotalResult + num1 + " / " + num2 + " = " + answer + " Sisa " + remainder + " Salah$");
                        }
                        break;
                }
            }

            // Menampilkan hasil pemain
            endTime = System.currentTimeMillis();
            playertime = (int) ((endTime - startTime) / 1000);
            System.out.println("\n\nAnda mencetak skor " + playerscore + " dari " + noOfQuestions);
            System.out.println("Waktu Anda adalah " + playertime + " detik");

            // Menampilkan semua soal dan jawaban pemain
            Methods.displayAnswers(noOfQuestions, playerTotalResult);

            // Menyimpan hasil pemain
            totalscore[index] = playerscore;
            totalscore[index + 1] = playertime;

            // Reset variabel
            playerscore = 0;
            playerTotalResult = "";
            index += 2;
        }

        // Mengurutkan dan meranking pemain
        Methods.rankArray(totalscore, names, noOfPlayers);
    }
}
