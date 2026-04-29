import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   SISTEM MANAJEMEN MAHASISWA & DOSEN");
        System.out.println("===========================================");

        // ===== INPUT DATA MAHASISWA =====
        System.out.println("\n--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa : ");
        String namaMhs = sc.nextLine();
        System.out.print("Alamat Mahasiswa : ");
        String alamatMhs = sc.nextLine();

        Student student = new Student(namaMhs, alamatMhs);
        System.out.println("Data mahasiswa berhasil dibuat: " + student);

        // Input mata kuliah & nilai mahasiswa
        System.out.print("\nBerapa mata kuliah yang ingin diinput? ");
        int jumlahMK = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < jumlahMK; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + " : ");
            String matkul = sc.nextLine();
            System.out.print("Nilai (0-100) : ");
            int nilai = Integer.parseInt(sc.nextLine());
            student.addCourseGrade(matkul, nilai);
        }

        // Tampilkan ringkasan mahasiswa
        System.out.println("\n--- Ringkasan Data Mahasiswa ---");
        System.out.println("Info   : " + student);
        student.printGrades();
        System.out.printf("Rata-rata Nilai : %.2f%n", student.getAverageGrade());

        // ===== INPUT DATA DOSEN =====
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Nama Dosen : ");
        String namaDosen = sc.nextLine();
        System.out.print("Alamat Dosen : ");
        String alamatDosen = sc.nextLine();

        Teacher teacher = new Teacher(namaDosen, alamatDosen);
        System.out.println("Data dosen berhasil dibuat: " + teacher);

        // Input mata kuliah yang diampu dosen
        System.out.print("\nBerapa mata kuliah yang diampu dosen? ");
        int jumlahMKDosen = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < jumlahMKDosen; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + " : ");
            String matkul = sc.nextLine();
            boolean added = teacher.addCourse(matkul);
            if (added) {
                System.out.println("  -> Berhasil ditambahkan.");
            } else {
                System.out.println("  -> Gagal: Mata kuliah sudah ada (duplikat).");
            }
        }

        // Demo hapus mata kuliah
        System.out.print("\nMasukkan nama mata kuliah yang ingin dihapus dari daftar dosen (atau tekan Enter untuk skip): ");
        String hapusMK = sc.nextLine();
        if (!hapusMK.isEmpty()) {
            boolean removed = teacher.removeCourse(hapusMK);
            if (removed) {
                System.out.println("Mata kuliah \"" + hapusMK + "\" berhasil dihapus.");
            } else {
                System.out.println("Mata kuliah \"" + hapusMK + "\" tidak ditemukan.");
            }
        }

        // Tampilkan ringkasan dosen
        System.out.println("\n--- Ringkasan Data Dosen ---");
        System.out.println("Info : " + teacher);
        teacher.printCourses();

        // ===== DEMO POLYMORPHISM =====
        System.out.println("\n--- Demo Polymorphism (Person[]) ---");
        Person[] persons = { student, teacher };
        for (Person p : persons) {
            System.out.println(p.toString());
        }

        System.out.println("\n===========================================");
        System.out.println("           Program Selesai!");
        System.out.println("===========================================");
        sc.close();
    }
}