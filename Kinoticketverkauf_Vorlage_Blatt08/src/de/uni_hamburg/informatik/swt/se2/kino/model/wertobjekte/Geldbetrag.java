package de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte;

/**
 * Ein Wertobjekt zur Darstellung ein Geldbetrags
 */
public final class Geldbetrag
{
    private int _euroCent;

    /**
     * Wählt einen Geldbetrag aus
     * 
     * @param euroCent das Geld
     * @required euroCent >= 0
     */
    private Geldbetrag(int euroCent)
    {
        assert euroCent >= 0 : "Vorbedingung verletzt: euroCent >= 0";

        _euroCent = euroCent;
    }

    /**
     * Erstellt ein Geldbetrag aus einem String, negative und unglültige Zahlen werden abgelehnt
     * @param s die Eingabe als Sting
     * @return einen neuen Geldbetrag
     */
    public static Geldbetrag get(String s)
    {
        if (s == null || !s.matches("\\d(,\\d{1,2})?"))
        {
            throw new IllegalArgumentException(s);
        }

        String[] teilString = s.split(",");
        int euro = Integer.parseInt(teilString[0]);
        int cent = 0;

        if (teilString.length == 2)
        {
            String centText = teilString[1];
            if (teilString[1].length() == 1)
            {
                centText = centText + "0";
            }
            cent = Integer.parseInt(centText);
        }

        return new Geldbetrag(euro * 100 + cent);
    }

    /**
     * Erstellt einen Geldbetrag aus euroCent
     * @param euroCent der Betrag in Cent
     * @return einen neuen Geldbetrag
     */
    public static Geldbetrag get(int euroCent)
    {
        return new Geldbetrag(euroCent);
    }

    @Override
    public boolean equals(Object o)
    {
        return (o instanceof Geldbetrag) && equals((Geldbetrag) o);
    }

    /**
     * Vergleich zwei Geldbeträge auf den gleichen Wert
     * @param andererGeldbetrag der zu vergleichende Betrag
     * @return true, wenn beide Beträge gleich sind
     */

    public boolean equals(Geldbetrag andererGeldbetrag)
    {
        return (_euroCent == andererGeldbetrag._euroCent);
    }

    /**
     * Liefert einen Hashwert für den Geldbetrag
     */
    @Override
    public int hashCode()
    {
        return 10007 * _euroCent;
    }

    /**
     * Gibt den Geldbetrag als Sting im Format Euro,Cent aus
     * 
     * @return formatierter Geldbetrag
     */
    public String toString()
    {
        int euro = _euroCent / 100;
        int cent = _euroCent % 100;
        return euro + "," + String.format("%02d", cent);
    }

    /**
     *  Überprüft, ob zwei Beträge addiert werden können, ohne überlauf
     *  @param andererGeldbetrag der andere Geldbetrag
     *  @return ob zwei Beträge addiert werden können
     */
    public boolean ueberpruefeAdd(Geldbetrag andererGeldbetrag)
    {
        try
        {
            Math.addExact(_euroCent, andererGeldbetrag._euroCent);
            return true;
        }
        catch (ArithmeticException e)
        {
            return false;
        }
    }

    /**
     * Addiert diesen Geldbetrag mit einen anderen, falls möglich 
     * @param andererGeldbetrag der andere Geldbetrag
     * @return neuer Geldbetrag
     */
    public Geldbetrag addiere(Geldbetrag andererGeldbetrag)
    {
        if (ueberpruefeAdd(andererGeldbetrag))
        {
            return get(Math.addExact(_euroCent, andererGeldbetrag._euroCent));
        }
        return get(_euroCent);
    }

    /**
     *  Überprüft, ob zwei Beträge subtrahiert werden können, ohne überlauf
     *  @param andererGeldbetrag der andere Geldbetrag
     *  @return ob zwei Beträge subtrahiert werden können
     */
    public boolean ueberpruefeSub(Geldbetrag andererGeldbetrag)
    {
        try
        {
            Math.subtractExact(_euroCent, andererGeldbetrag._euroCent);
            return true;
        }
        catch (ArithmeticException e)
        {
            return false;
        }
    }

    /**
     * Subtrahiert diesen Geldbetrag mit einen anderen, falls möglich 
     * @param andererGeldbetrag der andere Geldbetrag
     * @return neuer Geldbetrag
     */
    public Geldbetrag subtrahiere(Geldbetrag andererGeldbetrag)
    {
        if (ueberpruefeSub(andererGeldbetrag))
        {
            return get(
                    Math.subtractExact(_euroCent, andererGeldbetrag._euroCent));
        }
        return get(_euroCent);
    }

    /**
     *  Überprüft, ob zwei Beträge multipliziert werden können, ohne überlauf
     *  @param andererGeldbetrag der andere Geldbetrag
     *  @return ob zwei Beträge multipliziert werden können
     */
    public boolean ueberpruefeMult(int faktor)
    {
        try
        {
            Math.multiplyExact(_euroCent, faktor);
            return true;
        }
        catch (ArithmeticException e)
        {
            return false;
        }

    }

    /**
     * Multipliziert diesen Geldbetrag mit einen anderen, falls möglich 
     * @param andererGeldbetrag der andere Geldbetrag
     * @return neuer Geldbetrag
     */
    public Geldbetrag multipliziere(int faktor)
    {
        if (ueberpruefeMult(faktor))
        {
            return get(Math.multiplyExact(_euroCent, faktor));
        }
        return get(_euroCent);
    }

    /**
     * Prüft, ob dieser Betrag größer gleich der ander ist
     * @param andererGeldbetrag der andere Geldbetrag
     * @return ob dieser Betrag größer gleich der ander ist
     */
    public boolean groesserGleich(Geldbetrag andererGeldbetrag)
    {
        return _euroCent >= andererGeldbetrag._euroCent;
    }

    /**
     * Differenz zwischend dem Geldbeträgen
     * @param andererGeldbetrag der andere Geldbetrag
     * @return Differenz
     */
    public int compareTo(Geldbetrag andererGeldbetrag)
    {
        return _euroCent - andererGeldbetrag._euroCent;
    }

}
