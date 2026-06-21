package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.ProductSale;

public class Program {

	public static void main(String[] args) {

		File pthSales = new File(
				"C:\\Users\\Denis\\Documents\\Cursos\\Java\\Secao15\\Exercicios\\FilesForExercise\\sales.csv");
		List<ProductSale> sales = new ArrayList<>();

		try (BufferedReader bf = new BufferedReader(new FileReader(pthSales))) {
			String line;
			line = bf.readLine();
			String[] datas;
			while (line != null) {
				datas = line.split(",");
				ProductSale ps = new ProductSale(datas[0], Double.parseDouble(datas[1]), Integer.parseInt(datas[2]));
				sales.add(ps);
				line = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fld = new File(pthSales.getParent(), "\\out");
		fld.mkdir();
		
		File pthSummary = new File(fld + "\\Summary.csv");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pthSummary))) {
			for (ProductSale p : sales) {
				StringBuilder sb = new StringBuilder();
				sb.append(p.getName() + ',');
				sb.append(p.totalPrice());
				bw.write(sb.toString());
				bw.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
