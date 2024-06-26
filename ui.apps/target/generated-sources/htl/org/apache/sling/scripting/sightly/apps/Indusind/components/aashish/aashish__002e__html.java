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
package org.apache.sling.scripting.sightly.apps.Indusind.components.aashish;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class aashish__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _dynamic_model = bindings.get("model");
{
    String var_0 = (((((((((((((("<!--<div class=\"cmp-helloworld\" data-cmp-is=\"helloworld\">\r\n    <h2 class=\"cmp-helloworld__title\">Ash Component</h2>\r\n    <div class=\"cmp-helloworld__item\" data-sly-test=\"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "comment"))) + "\">\r\n        <p class=\"cmp-helloworld__item-label\">Text property:</p>\r\n        <pre class=\"cmp-helloworld__item-output\" data-cmp-hook-helloworld=\"property\">") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "comment"))) + "</pre>\r\n    </div>\r\n    <div class=\"cmp-helloworld__item\" data-sly-use.model=\"com.indusind.aem.platform.core.models.HelloWorldModel\" data-sly-test=\"") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_model, "message"), "comment"))) + "\">\r\n        <p class=\"cmp-helloworld__item-label\"Kuch Sandesh:</p>\r\n        <input type=\"text\" placeholder=\"message\">\r\n        <input type=\"submit\" value=\"Send\">\r\n        <pre class=\"cmp-helloworld__item-output\"data-cmp-hook-helloworld=\"model\">") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_model, "message"), "comment"))) + "</pre>\r\n    </div>\r\n    <img src=\"") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "img"), "comment"))) + "\"><br>\r\n    ") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title"), "comment"))) + " <br> ANS:  ") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "box"), "comment"))) + " \r\n</div>-->");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("\r\n\r\n\r\n\r\n\r\n<form id=\"createNodeForm\">\r\n    <label for=\"fname\">First Name:</label>\r\n    <input type=\"text\" id=\"fname\" name=\"fname\"/>\r\n      <br/>\r\n        <label for=\"lname\">Last Name:</label>\r\n        <input type=\"text\" id=\"lname\" name=\"lname\"/>\r\n          <br/>\r\n            <button type=\"button\" onclick=\"saveData()\">Submit</button>\r\n          </form>\r\n  \r\n  \r\n          <script>\r\n        debugger;\r\n            function saveData() {\r\n              debugger;\r\n            var fname = document.getElementById(\"fname\").value;\r\n       var lastname = document.getElementById(\"lname\").value;\r\n            debugger;\r\n  \r\n            var obj = {\r\n              \"name\":fname,\r\n                \"lastname\":lastname\r\n               };\r\n  \r\n            $.ajax({\r\n              url: \"/bin/custom/nodeservlet\",\r\n            type: 'POST',\r\n            data: JSON. stringify(obj),\r\n            cache: false,\r\n            contentType: 'application/json',\r\n            processData: false,\r\n  \r\n            success: function(data) {\r\n  \r\n  \r\n              alert(\"success\");\r\n      },\r\n            error: function(xhr, status, error) {\r\n              console.log(\"AJAX request error: \" + error);\r\n            alert(\"AJAX request error: \" + error);\r\n      }\r\n    });\r\n  };\r\n          </script>\r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  \r\n  ");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

