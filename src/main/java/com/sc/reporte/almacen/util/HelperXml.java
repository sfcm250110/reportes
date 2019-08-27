
package com.sc.reporte.almacen.util;

import com.sc.reporte.almacen.util.ConstantesXml;

import java.io.Serializable;

public class HelperXml implements Serializable {
        
        public static String generarTag(String pNombreTag, Object pValor) {
                StringBuilder tag = new StringBuilder();

                tag.append(openTag(pNombreTag));
                tag.append(pValor);
                tag.append(closeTag(pNombreTag));

                return tag.toString();
        }

        public static String openTag(String nombreTag) {
                StringBuilder openTag = new StringBuilder();

                openTag.append(ConstantesXml.TAG_INIT_OPEN);
                openTag.append(nombreTag);
                openTag.append(ConstantesXml.TAG_INIT_OPEN);

                return openTag.toString();
        }

        public static String closeTag(String nombreTag) {
                StringBuilder closeTag = new StringBuilder();

                closeTag.append(ConstantesXml.TAG_FIN_OPEN);
                closeTag.append(nombreTag);
                closeTag.append(ConstantesXml.TAG_FIN_CLOSE);

                return closeTag.toString();
        }
}
