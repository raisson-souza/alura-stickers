import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {

    void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem

        //                          new FileInputStream(new File("../entrada/filme.jpg"));
        //InputStream inputStream = 
        //                            new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem

        graphics.drawString("T0PZERA", (largura/3.5f), novaAltura - 100);

        // escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem, "png", new File("../saida/" + nomeArquivo));
    }
}
