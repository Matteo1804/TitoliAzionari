package it.unibs.ing.fp.titoliazionari;

import org.junit.Test;
import  static org.junit.Assert.*;

import java.io.Serializable;

/**
 * Created by sam on 22/05/17.
 */
public class SerializableTest {

    @Test
    public void isSerializable(){
      isSerializable(ElencoTitoli.class);
      isSerializable(Portafoglio.class);
      isSerializable(Titolo.class);
      isSerializable(Lotto.class);
      isSerializable(Contenitore.class);
    }

    private void isSerializable(Class t){
        assertTrue( t.getCanonicalName() + " do not implements Serializable", Serializable.class.isAssignableFrom(t));

    }

}
