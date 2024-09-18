import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DovizApp extends JFrame implements ActionListener {

    private JLabel lblDovizBirimi, lblDovizMiktari, lblSonuc;
    private JTextField txtDovizMiktari;
    private JButton btnHesapla, btnBilgi ,btngrafik;
	
    private JComboBox<String> cmbDovizBirimi;

    private JFrame bilgiFrame;

    public DovizApp() {
        setTitle("Döviz Uygulaması");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        lblDovizBirimi = new JLabel("Döviz Birimi");
        panel.add(lblDovizBirimi);

        cmbDovizBirimi = new JComboBox<>(new String[] 
        {"USD = ABD Doları", "EUR = Euro", "GBP = İngiliz Sterlini",
        "CHF = İsveç Frangı", "JPY = Japon Yeni", "INR = Hindistan Rupisi",
        "CAD = Kanada Doları","KRW = Güney Kore Wonu","BRL = Brezilya Reali",
        "AED = BAE Dirhemi","THB = Tayland Bahtı","DKK = Danimarka Kronu",
        "KWD = Kuveyt Dinarı","ILS = İsrail Şekeli","HUF = Macar Forinti",
        "IDR = Endonezya Rupiahi","AZN = Azerbaycan Manatı","ARS = Arjantin Pesosu",
        "AUD = Avustralya Doları","BGN = Bulgar Levası","ISK = İzlanda Kronası",
        
        
        });
        panel.add(cmbDovizBirimi);

        lblDovizMiktari = new JLabel("Döviz Miktarı");
        panel.add(lblDovizMiktari);

        txtDovizMiktari = new JTextField(10);
        txtDovizMiktari.setText("Değer Giriniz");
        txtDovizMiktari.setForeground(Color.WHITE);
        txtDovizMiktari.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                // Metin "Değer Giriniz" ise tıklanan metni temizle
                if (txtDovizMiktari.getText().equals("Değer Giriniz")) {
                    txtDovizMiktari.setText("");
                    Font iFont3 = new Font(txtDovizMiktari.getFont().getFamily(), Font.ITALIC,13);
                    txtDovizMiktari.setFont(iFont3);
                    txtDovizMiktari.setForeground(Color.WHITE);// Önplan rengini belirler
                }
            }

           
            public void mouseExited(MouseEvent e) {
                // Metin boş ise "Değer Giriniz" metnini tekrar yaz.
                if (txtDovizMiktari.getText().isEmpty()) {
                    txtDovizMiktari.setText("Değer Giriniz");
                    Font iFont3 = new Font(txtDovizMiktari.getFont().getFamily(), Font.ITALIC,13);
                    txtDovizMiktari.setFont(iFont3);
                    txtDovizMiktari.setForeground(Color.white);
                }
            }
        });
      
        panel.add(txtDovizMiktari);

        btnHesapla = new JButton("Hesapla");
        panel.add(btnHesapla);

        lblSonuc = new JLabel("");
        panel.add(lblSonuc);
        
      
        btnBilgi = new JButton("Yapımcılar ve Sürüm");
        panel.add(btnBilgi);
        
        btngrafik= new JButton("Grafik");
        panel.add(btngrafik);
        
        

        add(panel);
        
        
//////////////////////////////////////////////////////////////////////////////////////        /
        //Renklendirme
        lblSonuc.setBackground(Color.BLACK);
        lblSonuc.setOpaque(true); // Arkaplan renginin görünür olması için 
        Font boldFont1 = new Font(lblSonuc.getFont().getFamily(), Font.BOLD,15);
    	lblSonuc.setFont(boldFont1);
        lblSonuc.setForeground(Color.WHITE);
        
        
        
        btnBilgi.setBackground(new Color(128, 0, 0 )); // butonu kırmızı
        btnBilgi.setOpaque(true);
        Font boldFont2 = new Font(btnBilgi.getFont().getFamily(), Font.BOLD,14);
        btnBilgi.setFont(boldFont2);
        btnBilgi.setForeground(Color.white);
        
        
        btnHesapla.setBackground(new Color(0, 128, 128 )); // koyu yeşil
        btnHesapla.setOpaque(true);
        Font boldFont4 = new Font(btnHesapla.getFont().getFamily(), Font.BOLD,14);
        btnHesapla.setFont(boldFont4);
        btnHesapla.setForeground(Color.white);
        
        
        
        
        cmbDovizBirimi.setBackground(Color.BLACK); //
        cmbDovizBirimi.setOpaque(true);
        cmbDovizBirimi.setForeground(Color.white);
        Font iFont2 = new Font(cmbDovizBirimi.getFont().getFamily(), Font.ITALIC,13);
        cmbDovizBirimi.setFont(iFont2);
       
       
        
        
        lblDovizMiktari.setBackground(Color.BLACK); //
        lblDovizMiktari.setOpaque(true);
        Font iFont4 = new Font(lblDovizMiktari.getFont().getFamily(), Font.ITALIC,13);
        lblDovizMiktari.setFont(iFont4);
        lblDovizMiktari.setForeground(Color.white); 
        
        
        
        
        lblDovizBirimi.setBackground(Color.BLACK); //
        lblDovizBirimi.setOpaque(true);
        Font iFont1 = new Font(lblDovizBirimi.getFont().getFamily(), Font.ITALIC,13);
        lblDovizBirimi.setFont(iFont1);
        lblDovizBirimi.setForeground(Color.white); 
        
        
        
        txtDovizMiktari.setBackground(Color.BLACK); //
        txtDovizMiktari.setOpaque(true);
        txtDovizMiktari.setForeground(Color.white); 
        
        
        
        
        
        
      
       
   
        btngrafik.setBackground(new Color(60,0,111)); //mor renk
        btngrafik.setOpaque(true);
        btngrafik.setForeground(Color.white); 
        Font boldFont3 = new Font(btngrafik.getFont().getFamily(), Font.BOLD,14);
        btngrafik.setFont(boldFont3);
        
        
        
        
        
        
        
        
        btnHesapla.addActionListener(this);
        btnBilgi.addActionListener(this);
//////////////////////////////////////////////////////////////////////////////
        
        
        // Çıkış işlemini yakalamak için WindowListener ekleyin
        addWindowListener(new WindowAdapter() {
           
            public void windowClosing(WindowEvent e) {
                int sonuc = JOptionPane.showConfirmDialog(null, "Çıkmak istediğinize emin misiniz?", "Çıkış", JOptionPane.YES_NO_OPTION);
                if (sonuc == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "TEKRAR GÖRÜŞMEK ÜZERE ツ ", "Çıkış", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0); // Programı kapat
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        setVisible(true);
    }
/////////////////////////////////////////////////////////////////////////////////
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHesapla) {
            // Hesaplama işlemleri
            hesaplaDoviz();
        } else if (e.getSource() == btnBilgi) {
            // Yapımcılar ve sürüm bilgisi gösterme işlemleri
            showBilgiFrame();
        }
    }
//////////////////////////////////////////////////////////////////////////////
    private void hesaplaDoviz() {
        
    	 // Döviz miktarını kontrol eder
    	String dovizMiktariText = txtDovizMiktari.getText();
    	if (dovizMiktariText.isEmpty()) {
    	    JOptionPane.showMessageDialog(this, "Lütfen döviz miktarını girin.", "Hata", JOptionPane.ERROR_MESSAGE);
    	    return;
    	}

    	double dovizMiktari;
    	try {
    	    dovizMiktari = Double.parseDouble(dovizMiktariText);
    	} catch (NumberFormatException ex) {
    	    JOptionPane.showMessageDialog(this, "Lütfen geçerli bir döviz miktarı girin.", "Hata", JOptionPane.ERROR_MESSAGE);
    	    return;
    	}

    	

    	// Seçilen döviz birimini ve miktarını alır
    	String dovizBirimi = cmbDovizBirimi.getSelectedItem().toString();

/////////////////////////////////////////////////////////////

        double kur = 0.0;
        // Seçilen döviz birimine göre kur hesapla
        if (dovizBirimi.equalsIgnoreCase("USD = ABD Doları")) {
            kur = 19.99;
        } 
        else if (dovizBirimi.equalsIgnoreCase("EUR = Euro")) {
            kur = 21.44;
        } 
        else if (dovizBirimi.equalsIgnoreCase("GBP = İngiliz Sterlini")) {
            kur = 24.68;
        } 
        else if (dovizBirimi.equalsIgnoreCase("CHF = İsveç Frangı")) {
            kur = 21.95;
        } 
        else if (dovizBirimi.equalsIgnoreCase("JPY = Japon Yeni")) {
            kur = 0.14;
        }
        else if (dovizBirimi.equalsIgnoreCase("INR = Hindistan Rupisi")) {
            kur = 0.24;
        } 
        else if (dovizBirimi.equalsIgnoreCase("CAD = Kanada Doları")) {
            kur = 14.65;
        } 
        else if (dovizBirimi.equalsIgnoreCase("KRW = Güney Kore Wonu")) {
            kur = 0.015;
        }
        else if (dovizBirimi.equalsIgnoreCase("BRL = Brezilya Reali")) {
            kur = 3.99;
        } 
        else if (dovizBirimi.equalsIgnoreCase("AED = BAE Dirhemi")) {
            kur = 5.38;
        } 
        else if (dovizBirimi.equalsIgnoreCase("THB = Tayland Bahtı")) {
            kur = 0.58;
        }
        else if (dovizBirimi.equalsIgnoreCase("DKK = Danimarka Kronu")) {
            kur = 2.87;
        }
        else if (dovizBirimi.equalsIgnoreCase("KWD = Kuveyt Dinarı")) {
            kur = 64.30;
        }
        else if (dovizBirimi.equalsIgnoreCase("ILS = İsrail Şekeli")) {
            kur = 5.43;
        }
        else if (dovizBirimi.equalsIgnoreCase("HUF = Macar Forinti")) {
            kur = 0.0577;
        }
        else if (dovizBirimi.equalsIgnoreCase("IDR = Endonezya Rupiahi")) {
            kur = 0.0013;
        }
        else if (dovizBirimi.equalsIgnoreCase("AZN = Azerbaycan Manatı")) {
            kur = 11.28;
        }
        else if (dovizBirimi.equalsIgnoreCase("ARS = Arjantin Pesosu")) {
            kur = 0.0854;
        }
        else if (dovizBirimi.equalsIgnoreCase("AUD = Avustralya Doları")) {
            kur = 13.15;
        }
        else if (dovizBirimi.equalsIgnoreCase("BGN = Bulgar Levası")) {
            kur = 11;
        }
        else if (dovizBirimi.equalsIgnoreCase("ISK = İzlanda Kronası")) {
            kur = 0.1415;
        }
        
        
       
        
        else {
            
            return;
        }

        double sonuc = kur * dovizMiktari;
       
        lblSonuc.setText(String.format("%.2f TL", sonuc));
    }
//////////////////////////////////////////////////////////////////////////////
    private void showBilgiFrame() {
        bilgiFrame = new JFrame();
        bilgiFrame.setTitle("Hakkında");
        bilgiFrame.setSize(350, 300);
        bilgiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bilgiFrame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblBaslik = new JLabel("Ögr.Sena Nur Benli ");
        panel.add(lblBaslik, BorderLayout.NORTH);

        ImageIcon image = new ImageIcon("Istanbul_Gelisim_University_Logo.png"); // Resim dosyasının adını ve yolunu buraya giriliyor.
        Image scaledImage = image.getImage().getScaledInstance(130,-1, Image.SCALE_DEFAULT); // 130 piksel genişliğinde resim

        JLabel lblYapimcilar = new JLabel("<html><body>Mert Can Kızıldağ<br>İlayda Özdemir<br>Elif Odacı"
        		+ "<br></body></html>");
        lblYapimcilar.setIcon(new ImageIcon(scaledImage)); // Resim ikonunu ayarla
        lblYapimcilar.setHorizontalTextPosition(JLabel.CENTER);// Metni yatayda ortala
        lblYapimcilar.setVerticalTextPosition(JLabel.BOTTOM);// Metni dikeyde aşağıda konumlandır
        panel.add(lblYapimcilar, BorderLayout.CENTER);

        JLabel lblSurum = new JLabel("Sürüm: 1.0");
        lblSurum.setHorizontalAlignment(JLabel.RIGHT);// Metni sağa hizala
        panel.add(lblSurum, BorderLayout.SOUTH);

        bilgiFrame.add(panel);
        bilgiFrame.setVisible(true);
        
//////////////////////////////////////////////////////////////////////////////        
        
        
        
    }
    public static void main(String[] args) {
        new DovizApp();
       
    }
}

       
