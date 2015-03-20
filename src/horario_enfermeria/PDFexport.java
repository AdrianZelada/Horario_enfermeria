package horario_enfermeria;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;


public class PDFexport {

    static String[] turno;
    static String[] horario;
    static String[] grup;
    public static final String RESULT = "D://HorariosAsignados.pdf";
    public PDFexport(String[] turno1,String[]horario1,String []grup1){
        turno=turno1;
        horario=horario1;
        grup=grup1;
    }

    public static void main(String[] args) throws IOException, DocumentException {
        new PDFexport(turno,horario,grup).createPdf();
    }

    public void createPdf()
            throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        document.open();
        document.add(createFirstTable());
        document.close();
    }

    public static PdfPTable createFirstTable() {
        Integer tam =20;
        String nombre="--";
        String enfer[] = new String[tam];
        String tra;
        enfer=ConexionBD.get_enfermera(nombre, tam);


        PdfPTable table = new PdfPTable(6);
        PdfPCell cell, cell0,cell2;
        cell0 = new PdfPCell(new Phrase("LISTA DE ENFERMERAS"));
        cell0.setColspan(6);
        table.addCell(cell0);
        cell = new PdfPCell(new Phrase("Nombre"));
        table.addCell(cell);
        table.addCell("Paterno");
        table.addCell("Materno");
        table.addCell("Cargo");
        table.addCell("Item");
        table.addCell("Grupo");



        for (int i = 0; i < 12; i++) {
            tra=enfer[i];
            String [] datos=tra.split(" ");
            cell2 = new PdfPCell(new Phrase(datos[0]));
            table.addCell(cell2);
            table.addCell(datos[1]);
            table.addCell(datos[2]);
            table.addCell(datos[3]);
            table.addCell(datos[4]);
            table.addCell(datos[5]+" "+datos[6]);

        }
        cell0 = new PdfPCell(new Phrase("         "));
        cell0.setColspan(6);
        table.addCell(cell0);
        cell0 = new PdfPCell(new Phrase("TURNOS"));
        cell0.setColspan(6);
        table.addCell(cell0);

        cell0.setColspan(2);
        cell = new PdfPCell(new Phrase("Turno"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Horario"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Grupo"));
        cell.setColspan(2);
        table.addCell(cell);
        for(int i=0;i<turno.length;i++){
            cell = new PdfPCell(new Phrase(turno[i]));
            cell.setColspan(2);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(horario[i]));
            cell.setColspan(2);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(grup[i]));
            cell.setColspan(2);
            table.addCell(cell);

        }

        return table;
    }
}

