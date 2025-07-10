package de.uni_hamburg.informatik.swt.se2.kino.ui.platzverkauf;

import de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte.Geldbetrag;

public class BezahlController
{

    private BezahlView _view;
    private Geldbetrag _geldbetrag;
    private Geldbetrag _gezahlt;
    private Geldbetrag _rest;
    private boolean _erfolgreich;

    public BezahlController(Geldbetrag geldbetrag)
    {
        _geldbetrag = geldbetrag;
        _gezahlt = Geldbetrag.get(0);
        _rest = geldbetrag.subtrahiere(_gezahlt);
        _erfolgreich = false;
        _view = new BezahlView();
        aktualisiereBezahlView();
        registriereUIAktionen();
        _view.getUIDialog()
            .setModal(true);
        _view.getUIDialog()
            .setVisible(true);
    }

    private void aktualisiereBezahlView()
    {
        _view.getgesamtBetrag()
            .setText("Es sind " + _geldbetrag.toString() + "€ zu zahlen");
        _view.getbezahltBetrag()
            .setText("Es wurden " + _gezahlt.toString() + "€ gezahlt");
        _view.getrestBetrag()
            .setText("Es fehlen noch " + _rest.toString() + "€");
        _view.getokButton()
            .setEnabled(_erfolgreich);
    }

    private void registriereUIAktionen()
    {
        _view.getabbrechenButton()
            .addActionListener(e -> {
                _erfolgreich = false;
                _view.getUIDialog()
                    .dispose();
            });

        _view.getokButton()
            .addActionListener(e -> {
                _erfolgreich = true;
                _view.getUIDialog()
                    .dispose();
            });

        _view.getbezahlButton()
            .addActionListener(e -> bezahle());

    }

    private void bezahle()
    {
        String eingabe = _view.geteingabeFeld()
            .getText();
        if (eingabe == null || !eingabe.matches("\\d+(,\\d{1,2})?"))
        {
            _view.getrückmeldungText()
                .setText("Ungültige Eingabe");
        }
        else
        {
            if (Geldbetrag.get(eingabe)
                .ueberpruefeAdd(_gezahlt))
            {
                _gezahlt = _gezahlt.addiere(Geldbetrag.get(eingabe));
                _view.getrückmeldungText()
                    .setText("Gültige Eingabe");
            }

            else
            {
                _view.getrückmeldungText()
                    .setText("Ungültige Eingabe");
            }
            if (_gezahlt.groesserGleich(_geldbetrag))
            {
                _rest = Geldbetrag.get(0);
                _erfolgreich = true;
            }
            else
            {
                _rest = _geldbetrag.subtrahiere(_gezahlt);
            }
            aktualisiereBezahlView();
        }

    }

    public boolean istBezahlungErfolgreich()
    {
        return _erfolgreich;
    }

}
