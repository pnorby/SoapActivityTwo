package gov.noaa;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.Assert.*;
import java.io.*;

public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53597");
        System.out.println(result);
        JAXBContext jaxBContext = JAXBContext.newInstance();
        Unmarshaller jaxbUnmarshaller = jaxBContext.createUnmarshaller();

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));
        String latLonResult = dwml.getLatLonList();
        assertEquals("43.1866,-89.452", latLonResult);
    }

}