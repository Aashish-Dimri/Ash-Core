/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.Indusind.components.databaseCRUD;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class databaseCRUD__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
{
    boolean var_testvariable0 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "Create"));
    if (var_testvariable0) {
        out.write("\n   <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" value");
                        {
                            boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                            if (!var_istrueattr3) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n   <input type=\"hidden\" class=\"create\" id=\"fname\" name=\"fname\"");
        {
            Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "cfname");
            {
                Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                {
                    boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                    if (var_shoulddisplayattr8) {
                        out.write(" value");
                        {
                            boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                            if (!var_istrueattr7) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"create\" id=\"lname\" name=\"lname\"");
        {
            Object var_attrvalue9 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "clname");
            {
                Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
                {
                    boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                    if (var_shoulddisplayattr12) {
                        out.write(" value");
                        {
                            boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                            if (!var_istrueattr11) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"create\" id=\"id\" name=\"id\"");
        {
            Object var_attrvalue13 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "cid");
            {
                Object var_attrcontent14 = renderContext.call("xss", var_attrvalue13, "attribute");
                {
                    boolean var_shoulddisplayattr16 = (((null != var_attrcontent14) && (!"".equals(var_attrcontent14))) && ((!"".equals(var_attrvalue13)) && (!((Object)false).equals(var_attrvalue13))));
                    if (var_shoulddisplayattr16) {
                        out.write(" value");
                        {
                            boolean var_istrueattr15 = (var_attrvalue13.equals(true));
                            if (!var_istrueattr15) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent14));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"create\" id=\"position\" name=\"position\"");
        {
            Object var_attrvalue17 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "cposition");
            {
                Object var_attrcontent18 = renderContext.call("xss", var_attrvalue17, "attribute");
                {
                    boolean var_shoulddisplayattr20 = (((null != var_attrcontent18) && (!"".equals(var_attrcontent18))) && ((!"".equals(var_attrvalue17)) && (!((Object)false).equals(var_attrvalue17))));
                    if (var_shoulddisplayattr20) {
                        out.write(" value");
                        {
                            boolean var_istrueattr19 = (var_attrvalue17.equals(true));
                            if (!var_istrueattr19) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent18));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n");
    }
}
out.write("\n\n");
{
    boolean var_testvariable21 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "Update"));
    if (var_testvariable21) {
        out.write("\n   <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue22 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent23 = renderContext.call("xss", var_attrvalue22, "attribute");
                {
                    boolean var_shoulddisplayattr25 = (((null != var_attrcontent23) && (!"".equals(var_attrcontent23))) && ((!"".equals(var_attrvalue22)) && (!((Object)false).equals(var_attrvalue22))));
                    if (var_shoulddisplayattr25) {
                        out.write(" value");
                        {
                            boolean var_istrueattr24 = (var_attrvalue22.equals(true));
                            if (!var_istrueattr24) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent23));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n   <input type=\"hidden\" class=\"update\" id=\"fname\" name=\"fname\"");
        {
            Object var_attrvalue26 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ufname");
            {
                Object var_attrcontent27 = renderContext.call("xss", var_attrvalue26, "attribute");
                {
                    boolean var_shoulddisplayattr29 = (((null != var_attrcontent27) && (!"".equals(var_attrcontent27))) && ((!"".equals(var_attrvalue26)) && (!((Object)false).equals(var_attrvalue26))));
                    if (var_shoulddisplayattr29) {
                        out.write(" value");
                        {
                            boolean var_istrueattr28 = (var_attrvalue26.equals(true));
                            if (!var_istrueattr28) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent27));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"update\" id=\"lname\" name=\"lname\"");
        {
            Object var_attrvalue30 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ulname");
            {
                Object var_attrcontent31 = renderContext.call("xss", var_attrvalue30, "attribute");
                {
                    boolean var_shoulddisplayattr33 = (((null != var_attrcontent31) && (!"".equals(var_attrcontent31))) && ((!"".equals(var_attrvalue30)) && (!((Object)false).equals(var_attrvalue30))));
                    if (var_shoulddisplayattr33) {
                        out.write(" value");
                        {
                            boolean var_istrueattr32 = (var_attrvalue30.equals(true));
                            if (!var_istrueattr32) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent31));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"update\" id=\"id\" name=\"id\"");
        {
            Object var_attrvalue34 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "uid");
            {
                Object var_attrcontent35 = renderContext.call("xss", var_attrvalue34, "attribute");
                {
                    boolean var_shoulddisplayattr37 = (((null != var_attrcontent35) && (!"".equals(var_attrcontent35))) && ((!"".equals(var_attrvalue34)) && (!((Object)false).equals(var_attrvalue34))));
                    if (var_shoulddisplayattr37) {
                        out.write(" value");
                        {
                            boolean var_istrueattr36 = (var_attrvalue34.equals(true));
                            if (!var_istrueattr36) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent35));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n   <input type=\"hidden\" class=\"update\" id=\"position\" name=\"position\"");
        {
            Object var_attrvalue38 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "uposition");
            {
                Object var_attrcontent39 = renderContext.call("xss", var_attrvalue38, "attribute");
                {
                    boolean var_shoulddisplayattr41 = (((null != var_attrcontent39) && (!"".equals(var_attrcontent39))) && ((!"".equals(var_attrvalue38)) && (!((Object)false).equals(var_attrvalue38))));
                    if (var_shoulddisplayattr41) {
                        out.write(" value");
                        {
                            boolean var_istrueattr40 = (var_attrvalue38.equals(true));
                            if (!var_istrueattr40) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent39));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n");
    }
}
out.write("\n\n");
{
    boolean var_testvariable42 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "Delete"));
    if (var_testvariable42) {
        out.write("\n   <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue43 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent44 = renderContext.call("xss", var_attrvalue43, "attribute");
                {
                    boolean var_shoulddisplayattr46 = (((null != var_attrcontent44) && (!"".equals(var_attrcontent44))) && ((!"".equals(var_attrvalue43)) && (!((Object)false).equals(var_attrvalue43))));
                    if (var_shoulddisplayattr46) {
                        out.write(" value");
                        {
                            boolean var_istrueattr45 = (var_attrvalue43.equals(true));
                            if (!var_istrueattr45) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent44));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n   <input type=\"hidden\" class=\"delete\" id=\"id\" name=\"id\"");
        {
            Object var_attrvalue47 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "did");
            {
                Object var_attrcontent48 = renderContext.call("xss", var_attrvalue47, "attribute");
                {
                    boolean var_shoulddisplayattr50 = (((null != var_attrcontent48) && (!"".equals(var_attrcontent48))) && ((!"".equals(var_attrvalue47)) && (!((Object)false).equals(var_attrvalue47))));
                    if (var_shoulddisplayattr50) {
                        out.write(" value");
                        {
                            boolean var_istrueattr49 = (var_attrvalue47.equals(true));
                            if (!var_istrueattr49) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent48));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n");
    }
}
out.write("\n\n");
{
    boolean var_testvariable51 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "Read"));
    if (var_testvariable51) {
        out.write("\n   <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue52 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent53 = renderContext.call("xss", var_attrvalue52, "attribute");
                {
                    boolean var_shoulddisplayattr55 = (((null != var_attrcontent53) && (!"".equals(var_attrcontent53))) && ((!"".equals(var_attrvalue52)) && (!((Object)false).equals(var_attrvalue52))));
                    if (var_shoulddisplayattr55) {
                        out.write(" value");
                        {
                            boolean var_istrueattr54 = (var_attrvalue52.equals(true));
                            if (!var_istrueattr54) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent53));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n");
    }
}
out.write("\n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n<script>\n   $(document).ready(function() {\n      var source = document.querySelector(\".data_source\").getAttribute(\"value\");\n      if (source === \"Create\") {\n         var inputParameter = document.querySelectorAll(\".create\");\n         var tags = [];\n         for (let i = 0; i < inputParameter.length; i++) {\n            tags[i] = inputParameter[i].getAttribute(\"value\");\n         }\n         var dateToSend = {\n            'Source':source,\n            'fName':tags[0],\n            'lName':tags[1],\n            'id':tags[2],\n            'position':tags[3]\n         };\n         $.ajax({\n            url: \"/bin/crud\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      }\n      else if (source === \"Update\") {\n         var inputParameter = document.querySelectorAll(\".update\");\n         var tags = [];\n         for (let i = 0; i < inputParameter.length; i++) {\n            tags[i] = inputParameter[i].getAttribute(\"value\");\n         }\n         var dateToSend = {\n            'Source':source,\n            'fName':tags[0],\n            'lName':tags[1],\n            'id':tags[2],\n            'position':tags[3]\n         };\n         $.ajax({\n            url: \"/bin/crud\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      }\n\n      else if (source === \"Delete\") {\n         var inputParameter = document.querySelectorAll(\".delete\");\n         var tags = [];\n         for (let i = 0; i < inputParameter.length; i++) {\n            tags[i] = inputParameter[i].getAttribute(\"value\");\n         }\n         var dateToSend = {\n            'Source':source,\n            'id':tags[0]\n         };\n         $.ajax({\n            url: \"/bin/crud\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      }\n\n      else if (source === \"Read\") {\n         var dateToSend = {\n            'Source':source\n         };\n         $.ajax({\n            url: \"/bin/crud\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      }\n   });\n</script>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

