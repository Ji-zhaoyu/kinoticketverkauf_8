package de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte;

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

    /*
     public static Geldbetrag get(String s)
    {
        return new()
    }
     */

    public static Geldbetrag get(int euroCent)
    {
        return new Geldbetrag(euroCent);
    }

    public boolean equals(Geldbetrag andererGeldbetrag)
    {
        return (_euroCent == andererGeldbetrag._euroCent);
    }

    public int hashCode()
    {
        return 10007 * _euroCent;
    }

    public String toString()
    {
        int euro = _euroCent / 100;
        int cent = _euroCent % 100;
        return euro + "," + String.format("%02d", cent);
    }

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

    public Geldbetrag addiere(Geldbetrag andererGeldbetrag)
    {
        if (ueberpruefeAdd(andererGeldbetrag))
        {
            return get(Math.addExact(_euroCent, andererGeldbetrag._euroCent));
        }
        return get(_euroCent);
    }

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

    public Geldbetrag subtrahiere(Geldbetrag andererGeldbetrag)
    {
        if (ueberpruefeSub(andererGeldbetrag))
        {
            return get(
                    Math.subtractExact(_euroCent, andererGeldbetrag._euroCent));
        }
        return get(_euroCent);
    }

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

    public Geldbetrag multipliziere(int faktor)
    {
        if (ueberpruefeMult(faktor))
        {
            return get(Math.multiplyExact(_euroCent, faktor));
        }
        return get(_euroCent);
    }

    public boolean groesserGleich(Geldbetrag andererGeldbetrag)
    {
        return _euroCent >= andererGeldbetrag._euroCent;
    }

    public int CompareTo(Geldbetrag andererGeldbetrag)
    {
        return _euroCent - andererGeldbetrag._euroCent;
    }

}
