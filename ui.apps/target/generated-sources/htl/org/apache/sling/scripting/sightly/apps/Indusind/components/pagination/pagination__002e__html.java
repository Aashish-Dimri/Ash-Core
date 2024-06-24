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
package org.apache.sling.scripting.sightly.apps.Indusind.components.pagination;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class pagination__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\"/>\n  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n  <title>Data Display</title>\n  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\n  <script>\n    function loadDoc1(){\n      var container = document.getElementById(\"content\");\n      container.innerHTML = \"\";\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\n        for (var i = 0; i < 5; i++) {\n          var link = document.createElement(\"a\");\n          link.href = data[i].url;\n          link.innerText =  data[i].title;\n          container.appendChild(link);\n          container.appendChild(document.createElement(\"br\"));\n        }\n      })\n    }\n    function loadDoc2(){\n      var container = document.getElementById(\"content\");\n      container.innerHTML = \"\";\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\n        for (var i = 5; i < 10; i++) {\n          var link = document.createElement(\"a\");\n          link.href = data[i].url;\n          link.innerText =  data[i].title;\n          container.appendChild(link);\n          container.appendChild(document.createElement(\"br\"));\n        }\n      })\n    }\n    function loadDoc3(){\n      var container = document.getElementById(\"content\");\n      container.innerHTML = \"\";\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\n        for (var i = 10; i < 15; i++) {\n          var link = document.createElement(\"a\");\n          link.href = data[i].url;\n          link.innerText =  data[i].title;\n          container.appendChild(link);\n          container.appendChild(document.createElement(\"br\"));\n        }\n      })\n    }\n  </script>\n</head>\n\n<style>\n        #content,#buttons{\n  margin: auto;\n  width: 50%;\n  padding: 10px;\n}\n     </style>\n\n<body>\n  <div id=\"content\"></div>\n  <div id=\"buttons\">\n    <button type=\"button\" onclick=\"loadDoc1()\">1</button>\n    <button type=\"button\" onclick=\"loadDoc2()\">2</button>\n    <button type=\"button\" onclick=\"loadDoc3()\">3</button>\n  </div>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

