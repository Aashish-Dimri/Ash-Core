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

out.write("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n  <meta charset=\"UTF-8\"/>\r\n  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\r\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n  <title>Data Display</title>\r\n  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n  <script>\r\n    function loadDoc1(){\r\n      var container = document.getElementById(\"content\");\r\n      container.innerHTML = \"\";\r\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\r\n        for (var i = 0; i < 5; i++) {\r\n          var link = document.createElement(\"a\");\r\n          link.href = data[i].url;\r\n          link.innerText =  data[i].title;\r\n          container.appendChild(link);\r\n          container.appendChild(document.createElement(\"br\"));\r\n        }\r\n      })\r\n    }\r\n    function loadDoc2(){\r\n      var container = document.getElementById(\"content\");\r\n      container.innerHTML = \"\";\r\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\r\n        for (var i = 5; i < 10; i++) {\r\n          var link = document.createElement(\"a\");\r\n          link.href = data[i].url;\r\n          link.innerText =  data[i].title;\r\n          container.appendChild(link);\r\n          container.appendChild(document.createElement(\"br\"));\r\n        }\r\n      })\r\n    }\r\n    function loadDoc3(){\r\n      var container = document.getElementById(\"content\");\r\n      container.innerHTML = \"\";\r\n      $.getJSON(\"http://localhost:4502/bin/demo/querybuilder.0.0.1.html\", function(data) {\r\n        for (var i = 10; i < 15; i++) {\r\n          var link = document.createElement(\"a\");\r\n          link.href = data[i].url;\r\n          link.innerText =  data[i].title;\r\n          container.appendChild(link);\r\n          container.appendChild(document.createElement(\"br\"));\r\n        }\r\n      })\r\n    }\r\n  </script>\r\n</head>\r\n\r\n<style>\r\n        #content,#buttons{\r\n  margin: auto;\r\n  width: 50%;\r\n  padding: 10px;\r\n}\r\n     </style>\r\n\r\n<body>\r\n  <div id=\"content\"></div>\r\n  <div id=\"buttons\">\r\n    <button type=\"button\" onclick=\"loadDoc1()\">1</button>\r\n    <button type=\"button\" onclick=\"loadDoc2()\">2</button>\r\n    <button type=\"button\" onclick=\"loadDoc3()\">3</button>\r\n  </div>\r\n</body>\r\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

