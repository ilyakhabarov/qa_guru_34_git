package lesson09;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZipFileParsingTest {

    private final ClassLoader classLoader = ZipFileParsingTest.class.getClassLoader();


    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("zip_example.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void pdfFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("zip_example.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertTrue(pdf.author.contains("cefiro"));
                    assertTrue(pdf.text.contains("PDF File Example"));
                    assertTrue(pdf.text.contains("QA.Guru, 34 поток"));
                }
            }
        }
    }

    @Test
    void xlsxFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("zip_example.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    assertEquals("Калашников", xls.excel.getSheetAt(0).getRow(5).getCell(1).getStringCellValue());
                    assertEquals("Руководитель департамента", xls.excel.getSheetAt(0).getRow(5).getCell(5).getStringCellValue());
                }
            }
        }
    }

    @Test
    void csvFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("zip_example.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));

                    List<String[]> csvData = csvReader.readAll();
                    assertEquals(19, csvData.size());
                    assertArrayEquals(
                            new String[]{"QuotaAmount", "StartDate", "OwnerName", "Username"},
                            csvData.get(0));
                    assertEquals("2016-03-01", csvData.get(9)[1]);
                    assertEquals("Jessica Nichols", csvData.get(9)[2]);
                    assertEquals("trailhead19.d1fxj2goytkp@example.com", csvData.get(9)[3]);
                }
            }
        }
    }
}

