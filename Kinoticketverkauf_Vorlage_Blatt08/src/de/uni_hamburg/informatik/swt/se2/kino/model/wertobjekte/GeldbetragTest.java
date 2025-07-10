package de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{
    @Test
    public void testEqualsUndHashCode()
    {
        Geldbetrag geld1 = Geldbetrag.get(300);
        Geldbetrag geld2 = Geldbetrag.get(300);
        Geldbetrag geld3 = Geldbetrag.get("3,00");
        assertEquals(geld1, geld2);
        assertEquals(geld1, geld3);
        assertTrue(geld1.hashCode() == geld2.hashCode());
        assertTrue(geld1.hashCode() == geld3.hashCode());

        Geldbetrag geld4 = Geldbetrag.get(9);
        assertNotEquals(geld1, geld4);
        assertFalse(geld1.hashCode() == geld4.hashCode());

    }

    @Test
    public void testtoString()
    {
        Geldbetrag geld1 = Geldbetrag.get(300);
        assertEquals(geld1.toString(), "3,00");
    }

    @Test
    public void testAddiere()
    {
        Geldbetrag geld1 = Geldbetrag.get(300);
        Geldbetrag geld2 = Geldbetrag.get(345);
        Geldbetrag geld3 = Geldbetrag.get(Integer.MAX_VALUE);

        assertEquals(geld1.addiere(geld2), Geldbetrag.get(645));
        assertEquals(geld3.addiere(geld2), geld3);
    }

    @Test
    public void testSubtrahiere()
    {
        Geldbetrag geld1 = Geldbetrag.get(400);
        Geldbetrag geld2 = Geldbetrag.get(345);
        //Geldbetrag geld3 = Geldbetrag.get(Integer.MIN_VALUE);
        assertEquals(geld1.subtrahiere(geld2), Geldbetrag.get(55));
        //assertEquals(geld3.subtrahiere(geld2), geld3);
    }

    @Test
    public void testMultiplizere()
    {
        Geldbetrag geld1 = Geldbetrag.get(400);
        Geldbetrag geld2 = Geldbetrag.get(Integer.MAX_VALUE);
        //Geldbetrag geld3 = Geldbetrag.get(Integer.MIN_VALUE);
        assertEquals(geld1.multipliziere(1), Geldbetrag.get(400));
        assertEquals(geld2.multipliziere(2), geld2);
        //assertEquals(geld3.multipliziere(2), geld3);
    }

    @Test
    public void testGroesserGleich()
    {
        Geldbetrag geld1 = Geldbetrag.get(300);
        Geldbetrag geld2 = Geldbetrag.get(200);
        Geldbetrag geld3 = Geldbetrag.get(400);

        assertTrue(geld1.groesserGleich(geld2));
        assertTrue(geld1.groesserGleich(geld1));
        assertFalse(geld1.groesserGleich(geld3));
    }

}
