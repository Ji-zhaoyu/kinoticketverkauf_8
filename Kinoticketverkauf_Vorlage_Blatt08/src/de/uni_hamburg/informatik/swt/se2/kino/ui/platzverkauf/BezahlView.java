package de.uni_hamburg.informatik.swt.se2.kino.ui.platzverkauf;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BezahlView {
	private JDialog _Dialog;
    private JLabel _infoText;
    private JLabel _gesamtBetrag;
    private JLabel _bezahltBetrag;
    private JLabel _restBetrag;
    private JLabel _eingabeText;
    private JLabel _rückmeldungText;
    private JTextField _eingabeFeld;
    private JButton _bezahlButton;
    private JButton _abbrechenButton;
    private JButton _okButton;
    
    public BezahlView()
    {
    	_Dialog = erstelleDialog();
    }
    
    private JDialog erstelleDialog()
    {
        JDialog Dialog = new JDialog();
        Dialog.setSize(900, 700);
        Dialog.setLocationRelativeTo(null);
        Dialog.setTitle("Bezahlvorgang");

        JPanel hauptPanel = new JPanel();
        hauptPanel.setLayout(new BorderLayout());
       
        _infoText = new JLabel("Bezahlvorgang", JLabel.CENTER);
        _infoText.setFont(new Font("Arial", Font.BOLD,50));
        hauptPanel.add(_infoText, BorderLayout.NORTH);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(6,1));
        _gesamtBetrag = new JLabel();
        _gesamtBetrag.setFont(new Font("Arial", Font.BOLD,25));
        _bezahltBetrag = new JLabel();
        _bezahltBetrag.setFont(new Font("Arial", Font.BOLD,25));
        _restBetrag = new JLabel();
        _restBetrag.setFont(new Font("Arial", Font.BOLD,25));
        
        _bezahlButton = new JButton("Bezahlen");
        _bezahlButton.setFont(new Font("Arial", Font.BOLD,25));
        
        JPanel eingabePanel = new JPanel();
        eingabePanel.setLayout(new GridLayout(1,2));
        _eingabeText = new JLabel("Gebe den zu bezahlenden Betrag ein");
        _eingabeText.setFont(new Font("Arial", Font.BOLD,25));
        _eingabeFeld = new JTextField();
        _eingabeFeld.setFont(new Font("Arial", Font.BOLD,25));
        _rückmeldungText = new JLabel();
        _rückmeldungText.setFont(new Font("Arial", Font.BOLD,25));


        
        eingabePanel.add(_eingabeText);
        eingabePanel.add(_eingabeFeld);
        
        infoPanel.add(_gesamtBetrag);
        infoPanel.add(_bezahltBetrag);
        infoPanel.add(_restBetrag);
        infoPanel.add(eingabePanel);
        infoPanel.add(_bezahlButton);
        infoPanel.add(_rückmeldungText);        
        hauptPanel.add(infoPanel, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        _abbrechenButton = new JButton("Abbrechen");
        _abbrechenButton.setFont(new Font("Arial", Font.BOLD,25));
        _okButton = new JButton("Ok");
        _okButton.setFont(new Font("Arial", Font.BOLD,25));

        buttonPanel.add(_okButton);
        buttonPanel.add(_abbrechenButton);
        buttonPanel.setPreferredSize(new Dimension(0, 150));
        
        
        hauptPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        
        Dialog.add(hauptPanel);
        Dialog.setVisible(true);
        Dialog.setModal(true);
        return Dialog;
    }
    
    public JDialog getUIDialog()
    {
        return _Dialog;
    }
    
    public JLabel getinfoText()
    {
        return _infoText;
    }
    
    public JLabel getgesamtBetrag()
    {
        return _gesamtBetrag;
    }
    
    public JLabel getbezahltBetrag()
    {
        return _bezahltBetrag;
    }
    
    public JLabel getrestBetrag()
    {
        return _restBetrag;
    }
    
    public JLabel geteingabeText()
    {
        return _eingabeText;
    }
    
    public JLabel getrückmeldungText()
    {
    	return _rückmeldungText;
    }
    
    public JTextField geteingabeFeld()
    {
        return _eingabeFeld;
    }
    
    public JButton getbezahlButton()
    {
        return _bezahlButton;
    }
    
    public JButton getabbrechenButton()
    {
        return _abbrechenButton;
    }
    
    public JButton getokButton()
    {
        return _okButton;
    }
    
    
}
