package test;

import util.SemaphoreExecutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    private ExecutorService pool;
    private SemaphoreExecutor semaphore;

    private Set<String> duplNoSet = Collections.synchronizedSet(new HashSet<>());

    ThreadTest (int threadCnt) {

        pool = Executors.newFixedThreadPool(threadCnt);
        semaphore = new SemaphoreExecutor(pool, threadCnt);

    }

    public void init() {

        final String file = "D:/data/test.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                try {

                    String finalLine = line;
                    semaphore.submitTask(() -> {

                        try {

                            List<String> list = this.process(finalLine);

                            if (list != null) {
                                this.writer(list);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            pool.shutdown();
            while (!pool.isTerminated());

            System.out.println();
            System.out.println(String.join(",",duplNoSet) + ":" + duplNoSet.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    private List<String> process(String no) {

        if (duplNoSet.contains(no)) {
            duplNoSet.remove(no);
            return null;
        } else {
            duplNoSet.add(no + "*");
            return new ArrayList<>(getSearchNoList(no));
        }
    }

    /**
     *
     */
    private void writer(List<String> list) {

        List<String> outNoList = new ArrayList<>();

        for (String no : list) {

            if (duplNoSet.contains(no + "*")) {

                duplNoSet.remove(no + "*");
                outNoList.add(no);

            } else {

                duplNoSet.add(no);
                outNoList.add(no);
            }

        }

        System.out.println(Thread.currentThread().getName() + " : " + String.join(",", outNoList));

    }

    private List<String> getSearchNoList(String no) {

        List<String> noList = new ArrayList<>();

        switch (no) {
//            case "PD1": case "PD2": case "PD3":
//                noList.add("PD1");
//                noList.add("PD2");
//                noList.add("PD3");
//                break;
//            case "PD4": case "PD5":
//                noList.add("PD4");
//                noList.add("PD5");
//                break;
//            case "PD6": case "PD7": case "PD8":
//                noList.add("PD6");
//                noList.add("PD7");
//                noList.add("PD8");
//                break;
//            case "PD9": case "PD10":
//                noList.add("PD9");
//                noList.add("PD10");
//                break;
            case "PD1": case "PD5": case "PD6":
                noList.add("PD1");
                noList.add("PD5");
                noList.add("PD6");
                break;
            case "PD2": case "PD4":
                noList.add("PD2");
                noList.add("PD4");
                break;
            case "PD3": case "PD7": case "PD9":
                noList.add("PD3");
                noList.add("PD7");
                noList.add("PD9");
                break;
            case "PD8": case "PD10":
                noList.add("PD8");
                noList.add("PD10");
                break;
        }

        return noList;
    }

    /**
     * test 파일 생성
     * @param a
     */
    public static void main(String[] a) {

        ThreadTest t = new ThreadTest(2);
        t.init();


//        final String file = "D:/data/test.csv";
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
//
//           for (int i = 1; i <= 10; i++) {
//               bw.write("PD" + i);
//               bw.newLine();
//               bw.flush();
//           }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
/* ------------------------------------------------------------------------- */
//        Random r = new Random();
//        List<String> list = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//
//            int random = i + r.nextInt(3) + 2;
//            StringBuilder sb = new StringBuilder();
//            for (; i < random; i++) {
//                sb.append("TEST").append(i);
//                if (i != random - 1) {
//                    sb.append(",");
//                }
//            }
//            list.add(sb.toString());
//        }
//
//        final String file = "D:/data/test.csv";
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
//
//            list.forEach(x -> {
//                try {
//                    for (int i = 0; i < x.split(",").length; i++) {
//                        bw.write(x);
//                        bw.newLine();
//                        bw.flush();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
