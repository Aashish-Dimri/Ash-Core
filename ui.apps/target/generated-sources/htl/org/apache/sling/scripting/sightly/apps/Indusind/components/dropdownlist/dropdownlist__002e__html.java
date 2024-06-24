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
package org.apache.sling.scripting.sightly.apps.Indusind.components.dropdownlist;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class dropdownlist__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _dynamic_resource = bindings.get("resource");
Collection var_collectionvar8_list_coerced$ = null;
Collection var_collectionvar19_list_coerced$ = null;
out.write("Data:\n<select class=\"data_source\" name=\"source\"");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" value");
                {
                    boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                    if (!var_istrueattr2) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("></select>\n<input class=\"inp\" type=\"hidden\" name=\"Insert Table\"");
{
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text1");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "attribute");
        {
            boolean var_shoulddisplayattr7 = (((null != var_attrcontent5) && (!"".equals(var_attrcontent5))) && ((!"".equals(var_attrvalue4)) && (!((Object)false).equals(var_attrvalue4))));
            if (var_shoulddisplayattr7) {
                out.write(" value");
                {
                    boolean var_istrueattr6 = (var_attrvalue4.equals(true));
                    if (!var_istrueattr6) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent5));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\n");
{
    Object var_collectionvar8 = renderContext.getObjectModel().resolveProperty(_dynamic_resource, "children");
    {
        long var_size9 = ((var_collectionvar8_list_coerced$ == null ? (var_collectionvar8_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar8)) : var_collectionvar8_list_coerced$).size());
        {
            boolean var_notempty10 = (var_size9 > 0);
            if (var_notempty10) {
                {
                    long var_end13 = var_size9;
                    {
                        boolean var_validstartstepend14 = (((0 < var_size9) && true) && (var_end13 > 0));
                        if (var_validstartstepend14) {
                            if (var_collectionvar8_list_coerced$ == null) {
                                var_collectionvar8_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar8);
                            }
                            long var_index15 = 0;
                            for (Object child : var_collectionvar8_list_coerced$) {
                                {
                                    boolean var_traversal17 = (((var_index15 >= 0) && (var_index15 <= var_end13)) && true);
                                    if (var_traversal17) {
                                        out.write("\n   ");
                                        {
                                            boolean var_testvariable18 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(child, "name"), "multi"));
                                            if (var_testvariable18) {
                                                out.write("\n      ");
                                                {
                                                    Object var_collectionvar19 = renderContext.getObjectModel().resolveProperty(child, "children");
                                                    {
                                                        long var_size20 = ((var_collectionvar19_list_coerced$ == null ? (var_collectionvar19_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar19)) : var_collectionvar19_list_coerced$).size());
                                                        {
                                                            boolean var_notempty21 = (var_size20 > 0);
                                                            if (var_notempty21) {
                                                                {
                                                                    long var_end24 = var_size20;
                                                                    {
                                                                        boolean var_validstartstepend25 = (((0 < var_size20) && true) && (var_end24 > 0));
                                                                        if (var_validstartstepend25) {
                                                                            if (var_collectionvar19_list_coerced$ == null) {
                                                                                var_collectionvar19_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar19);
                                                                            }
                                                                            long var_index26 = 0;
                                                                            for (Object childitems : var_collectionvar19_list_coerced$) {
                                                                                {
                                                                                    boolean var_traversal28 = (((var_index26 >= 0) && (var_index26 <= var_end24)) && true);
                                                                                    if (var_traversal28) {
                                                                                        out.write("\n          <input class=\"inp\" type=\"hidden\" name=\"actualValue\"");
                                                                                        {
                                                                                            Object var_attrvalue29 = renderContext.getObjectModel().resolveProperty(childitems, "actualValue");
                                                                                            {
                                                                                                Object var_attrcontent30 = renderContext.call("xss", var_attrvalue29, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr32 = (((null != var_attrcontent30) && (!"".equals(var_attrcontent30))) && ((!"".equals(var_attrvalue29)) && (!((Object)false).equals(var_attrvalue29))));
                                                                                                    if (var_shoulddisplayattr32) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr31 = (var_attrvalue29.equals(true));
                                                                                                            if (!var_istrueattr31) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent30));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        out.write("/>\n          <input class=\"inp\" type=\"hidden\" name=\"displayValue\"");
                                                                                        {
                                                                                            Object var_attrvalue33 = renderContext.getObjectModel().resolveProperty(childitems, "displayValue");
                                                                                            {
                                                                                                Object var_attrcontent34 = renderContext.call("xss", var_attrvalue33, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr36 = (((null != var_attrcontent34) && (!"".equals(var_attrcontent34))) && ((!"".equals(var_attrvalue33)) && (!((Object)false).equals(var_attrvalue33))));
                                                                                                    if (var_shoulddisplayattr36) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr35 = (var_attrvalue33.equals(true));
                                                                                                            if (!var_istrueattr35) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent34));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        out.write("/> \n          <input class=\"inp\" type=\"hidden\" name=\"primaryValue\"");
                                                                                        {
                                                                                            Object var_attrvalue37 = renderContext.getObjectModel().resolveProperty(childitems, "primaryValue");
                                                                                            {
                                                                                                Object var_attrcontent38 = renderContext.call("xss", var_attrvalue37, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr40 = (((null != var_attrcontent38) && (!"".equals(var_attrcontent38))) && ((!"".equals(var_attrvalue37)) && (!((Object)false).equals(var_attrvalue37))));
                                                                                                    if (var_shoulddisplayattr40) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr39 = (var_attrvalue37.equals(true));
                                                                                                            if (!var_istrueattr39) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent38));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        out.write("/>\n          <input class=\"inp\" type=\"hidden\" name=\"primaryCol\"");
                                                                                        {
                                                                                            Object var_attrvalue41 = renderContext.getObjectModel().resolveProperty(childitems, "primaryCol");
                                                                                            {
                                                                                                Object var_attrcontent42 = renderContext.call("xss", var_attrvalue41, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr44 = (((null != var_attrcontent42) && (!"".equals(var_attrcontent42))) && ((!"".equals(var_attrvalue41)) && (!((Object)false).equals(var_attrvalue41))));
                                                                                                    if (var_shoulddisplayattr44) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr43 = (var_attrvalue41.equals(true));
                                                                                                            if (!var_istrueattr43) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent42));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        out.write("/>\n        ");
                                                                                    }
                                                                                }
                                                                                var_index26++;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    var_collectionvar19_list_coerced$ = null;
                                                }
                                                out.write("\n   ");
                                            }
                                        }
                                        out.write("\n");
                                    }
                                }
                                var_index15++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar8_list_coerced$ = null;
}
out.write("\n");
{
    boolean var_testvariable45 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "Json"));
    if (var_testvariable45) {
        out.write("\n   <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue46 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent47 = renderContext.call("xss", var_attrvalue46, "attribute");
                {
                    boolean var_shoulddisplayattr49 = (((null != var_attrcontent47) && (!"".equals(var_attrcontent47))) && ((!"".equals(var_attrvalue46)) && (!((Object)false).equals(var_attrvalue46))));
                    if (var_shoulddisplayattr49) {
                        out.write(" value");
                        {
                            boolean var_istrueattr48 = (var_attrvalue46.equals(true));
                            if (!var_istrueattr48) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent47));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n   <input type=\"hidden\" class=\"jsons\" id=\"homepage\" name=\"jsonLink\"");
        {
            Object var_attrvalue50 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "links");
            {
                Object var_attrcontent51 = renderContext.call("xss", var_attrvalue50, "attribute");
                {
                    boolean var_shoulddisplayattr53 = (((null != var_attrcontent51) && (!"".equals(var_attrcontent51))) && ((!"".equals(var_attrvalue50)) && (!((Object)false).equals(var_attrvalue50))));
                    if (var_shoulddisplayattr53) {
                        out.write(" value");
                        {
                            boolean var_istrueattr52 = (var_attrvalue50.equals(true));
                            if (!var_istrueattr52) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent51));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/><br/>\n");
    }
}
out.write("\n\n  ");
{
    boolean var_testvariable54 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown"), "File"));
    if (var_testvariable54) {
        out.write("\n  <select class=\"data_source\" name=\"source\"");
        {
            Object var_attrvalue55 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "dataDropdown");
            {
                Object var_attrcontent56 = renderContext.call("xss", var_attrvalue55, "attribute");
                {
                    boolean var_shoulddisplayattr58 = (((null != var_attrcontent56) && (!"".equals(var_attrcontent56))) && ((!"".equals(var_attrvalue55)) && (!((Object)false).equals(var_attrvalue55))));
                    if (var_shoulddisplayattr58) {
                        out.write(" value");
                        {
                            boolean var_istrueattr57 = (var_attrvalue55.equals(true));
                            if (!var_istrueattr57) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent56));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n  <select class=\"file_type\" name=\"file\" id=\"type\"");
        {
            Object var_attrvalue59 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "file");
            {
                Object var_attrcontent60 = renderContext.call("xss", var_attrvalue59, "attribute");
                {
                    boolean var_shoulddisplayattr62 = (((null != var_attrcontent60) && (!"".equals(var_attrcontent60))) && ((!"".equals(var_attrvalue59)) && (!((Object)false).equals(var_attrvalue59))));
                    if (var_shoulddisplayattr62) {
                        out.write(" value");
                        {
                            boolean var_istrueattr61 = (var_attrvalue59.equals(true));
                            if (!var_istrueattr61) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent60));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("></select>\n   <input class=\"filepath\" type=\"hidden\" name=\"path\" id=\"files\"");
        {
            Object var_attrvalue63 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "documentPath");
            {
                Object var_attrcontent64 = renderContext.call("xss", var_attrvalue63, "attribute");
                {
                    boolean var_shoulddisplayattr66 = (((null != var_attrcontent64) && (!"".equals(var_attrcontent64))) && ((!"".equals(var_attrvalue63)) && (!((Object)false).equals(var_attrvalue63))));
                    if (var_shoulddisplayattr66) {
                        out.write(" value");
                        {
                            boolean var_istrueattr65 = (var_attrvalue63.equals(true));
                            if (!var_istrueattr65) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent64));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\n  ");
    }
}
out.write("\n\n<script>\n   $(document).ready(function() {\n      var source = document.querySelector(\".data_source\").getAttribute(\"value\");\n      if (source === \"Database\") {\n         var inputParameter = document.querySelectorAll(\".inp\");\n         var tags = [];\n         for (let i = 0; i < inputParameter.length; i++) {\n            tags[i] = inputParameter[i].getAttribute(\"value\");\n         }\n         var dateToSend = {\n            'Source':source,\n            'Table':tags[0],\n            'Actual':tags[1],\n            'Display':tags[2],\n            'Primary':tags[3],\n            'PriCol':tags[4],\n         };\n         $.ajax({\n            url: \"/bin/ayasya/runmode\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n               var name = data.split(\"\\n\");\n               var number = name[name.length-2];\n               var container = document.getElementById(\"container\");\n               while (container.hasChildNodes()) {\n                  container.removeChild(container.lastChild);\n               }\n               for (i=0;i<number;i++){\n                var input = document.createElement(\"input\");\n                input.id=\"inputText\"+(i+1);\n                input.type = \"text\";\n                input.value = name[i];\n                container.appendChild(input);\n                input.setAttribute('readonly', true);\n                container.appendChild(document.createElement(\"br\"));\n               }\n               $(\"#member\").val(name[name.length-2]);\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      } else if (source === \"Json\") {\n         var jsonLink = document.getElementById(\"homepage\").getAttribute(\"value\");\n         console.log(\"jsonLink: \" + jsonLink);\n         var dateToSend = {\n            'jsonLink': jsonLink\n         };\n         $.ajax({\n            url: \"/bin/ayasya/runmode\",\n            type: \"POST\",\n            data: dateToSend,\n            success: function(data) {\n               console.log(\"AJAX request successful\");\n               console.log(data);\n               if (Array.isArray(data)) {\n                  var textOutput = \"\";\n                  for (let i = 0; i < data.length; i++) {\n                     if (\n                        data[i].hasOwnProperty(\"id\") &&\n                        data[i].hasOwnProperty(\"name\") &&\n                        data[i].hasOwnProperty(\"email\")\n                     ) {\n                        var id = data[i].id;\n                        var name = data[i].name;\n                        var email = data[i].email;\n                        var phone = data[i].phone;\n                        textOutput +=\"id: \" + id + \"\\nname: \" + name + \"\\nemail: \" +  email +  \"\\n\\n\";\n                     } else {\n                        console.log(\n                           \"The 'id' field is missing in object at index \" + i\n                        );\n                     }\n                  }\n\n                  var textOutput1 = \"\";\n                  for (let i = 0; i < data.length; i++) {\n                     if (data[i].id === 4) {\n                        var id = data[i].id;\n                        var name = data[i].name;\n                        var email = data[i].email;\n                        var phone = data[i].phone;\n                        textOutput1 +=  \"id: \" + id +   \"\\nname: \" +  name +  \"\\nemail: \" +  email + \"\\nphone: \" + phone +  \"\\n\\n\";\n                     }\n                  }\n\n                  document.getElementById(\"myTextArea\").innerHTML = textOutput;\n                  document.getElementById(\"myTextArea1\").innerHTML = textOutput1;\n               } else {\n                  console.log(\"The JSON response is not an array.\");\n               }\n            },\n            error: function(xhr, status, error) {\n               console.log(\"AJAX request error: \" + error);\n            }\n         });\n      }  else if (source === \"File\") {\n         var path = document.getElementById(\"files\").getAttribute(\"value\");\n         var fileType = document.getElementById(\"type\").getAttribute(\"value\");\nvar dateToSend = {\n            'source':\"File\",\n            'filePath': path,\n            'type': fileType\n         };\nconsole.log(\"Filepath: \" + path);\n$.ajax({\n   url: \"/bin/comp/file\",\n   type: \"POST\",\n   data: dateToSend,\n   success: function(data) {\n      console.log(\"AJAX request successful\");\n    if(path.endsWith(\".csv\")){\n     var lines = data.split('\\r\\n');\n     var header = lines[0].split(',');\n     var jsonData = [];\n     for (var i = 1; i < lines.length; i++) {\n       var values = lines[i].split(',');\n       var entry = {};\n      for (var j = 0; j < header.length; j++) {\n        entry[header[j]] = values[j];\n  }\n  jsonData.push(entry);\n}\n document.getElementById(\"myTextArea\").innerHTML = JSON.stringify(jsonData);\n     }\n     else{\n      document.getElementById(\"myTextArea\").innerHTML = data;\n     }\n   },\n   error: function(xhr, status, error) {\n      console.log(\"AJAX request error: \" + error);\n   }\n});\n\n      }\n   });\n\n\n</script>\n<input type=\"hidden\" id=\"member\" name=\"member\"/>\n<input type=\"hidden\" id=\"filldetails\" onclick=\"addFields()\" value=\"Fill Details\"/>\n<div id=\"container\"></div><br/>\n\n<form name=\"\" method=\"POST\" action=\"/apps/demo/form\">\n   <select id=\"actionSelect\" name=\"action\" onchange=\"dropDown()\">\n      <option value=\"add\">Add Record</option>\n      <option value=\"update\">Update Record</option>\n      <option value=\"delete\">Delete Record</option>\n   </select>\n   <br/>\n   <div id=\"nameGroup\">\n      <label for=\"firstName\">Name</label><br/>\n      <input id=\"firstName\" type=\"text\" name=\"firstName\"/><br/>\n   </div>\n   <label for=\"id\">Id</label><br/>\n   <input id=\"id\" type=\"number\" name=\"id\" class=\"id-field\"/> <br/>\n   <div id=\"positionGroup\">\n      <label for=\"position\">Position</label><br/>\n      <input id=\"position\" type=\"text\" name=\"position\"/>\n   </div>\n   <input type=\"submit\" name=\"submit\" value=\"submit\"/>\n</form>\n<br/>\nchecking json data:-\n<br/>\n<div id=\"jsonDiv\">\n<textarea id=\"myTextArea\" cols=\"125\" rows=\"25\"></textarea>\n<textarea id=\"myTextArea1\" cols=\"50\" rows=\"25\"></textarea>\n</div>\n\n<script>\n   var dropdwonVal = document.getElementById(\"actionSelect\");\n\n           function dropDown(){\n               var dropVal = dropdwonVal.options[dropdwonVal.selectedIndex].text;\n               if(dropVal == \"Delete Record\"){\n                   document.getElementById(\"nameGroup\").style.display = \"none\";\n                   document.getElementById(\"positionGroup\").style.display = \"none\";\n               }else{\n                   document.getElementById(\"nameGroup\").style.display = \"block\";\n                   document.getElementById(\"positionGroup\").style.display = \"block\";\n               }\n           }\n</script>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

