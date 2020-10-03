package br.com.kleber.analisedadosapi.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class AnalisarDadosService {

    private final String PATH_DATA = System.getProperty("user.home").concat("/data");

    private final String PATH_DATA_IN = PATH_DATA.concat("/in");

    private final String PATH_DATA_OUT = PATH_DATA.concat("/out");

    public void analisar() {
        verificarDiretorios();
        verificarArquivos();
    }

    private void verificarDiretorios() {
        File file = new File(PATH_DATA);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(PATH_DATA_IN);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(PATH_DATA_OUT);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private void verificarArquivos() {
        try {
            Path path = Paths.get(PATH_DATA_IN);
            Files.list(path).forEach(pathFile -> {
                if (!new File(PATH_DATA_OUT.concat("/").concat(pathFile.toFile().getName())).exists()) {
                    analisarArquivo(pathFile);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void analisarArquivo(Path pathFile) {
        List<Vendedor> vendedores = new ArrayList();
        List<Cliente> clientes = new ArrayList();
        List<Venda> vendas = new ArrayList();
        try {
            Files.lines(pathFile).forEach(linha -> {
                List<String> dados = Arrays.asList(linha.split("ç"));

                switch (dados.get(0)) {
                    case "001": {
                        vendedores.add(new Vendedor(dados));
                        break;
                    }
                    case "002": {
                        clientes.add(new Cliente(dados));
                        break;
                    }
                    case "003": {
                        vendas.add(new Venda(dados));
                        break;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(PATH_DATA_OUT.concat("/").concat(pathFile.toFile().getName()))) {
            processarClientes(clientes, fileWriter);
            processarVendedores(vendedores, fileWriter);
            processarVendas(vendas, fileWriter);
        } catch (IOException ex) {
            Logger.getLogger(AnalisarDadosService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void processarClientes(List<Cliente> clientes, FileWriter fileWriter) throws IOException {
        fileWriter.write("Total de clientes: ".concat(Integer.toString(clientes.size())));
        fileWriter.write(System.lineSeparator());
    }

    private void processarVendedores(List<Vendedor> vendedores, FileWriter fileWriter) throws IOException {
        fileWriter.write("Total de vendedores: ".concat(Integer.toString(vendedores.size())));
        fileWriter.write(System.lineSeparator());
    }

    private void processarVendas(List<Venda> vendas, FileWriter fileWriter) throws IOException {
        Venda melhorVenda = null;
        List<String> melhorVendas = new ArrayList();

        Venda piorVenda = null;
        List<String> piorVendedores = new ArrayList();

        for (Venda venda : vendas) {
            if (melhorVenda == null || melhorVenda.getTotal().compareTo(venda.getTotal()) < 0) {
                melhorVendas = new ArrayList();
                melhorVendas.add(venda.getVendaId());
                melhorVenda = venda;
            } else if (melhorVenda.getTotal().compareTo(venda.getTotal()) == 0) {
                if (!melhorVendas.contains(venda.getVendaId())) {
                    melhorVendas.add(venda.getVendaId());
                }
            }

            if (piorVenda == null || piorVenda.getTotal().compareTo(venda.getTotal()) > 0) {
                piorVendedores = new ArrayList();
                piorVendedores.add(venda.getVendedor());
                piorVenda = venda;
            } else if (piorVenda.getTotal().compareTo(venda.getTotal()) == 0) {
                if (!piorVendedores.contains(venda.getVendedor())) {
                    piorVendedores.add(venda.getVendedor());
                }
            }
        }

        fileWriter.write("ID Melhor(es) venda(s): "
                .concat(melhorVendas.isEmpty() ? "Nenhuma venda encontrada" : melhorVendas.toString()));
        fileWriter.write(System.lineSeparator());
        fileWriter.write("Pior(es) vendedor(es): "
                .concat(piorVendedores.isEmpty() ? "Nenhuma venda encontrada" : piorVendedores.toString()));
        fileWriter.write(System.lineSeparator());
    }

}
