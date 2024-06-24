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
    String var_0 = (((((((((((((("<!--<div class=\"cmp-helloworld\" data-cmp-is=\"helloworld\">\n    <h2 class=\"cmp-helloworld__title\">Ash Component</h2>\n    <div class=\"cmp-helloworld__item\" data-sly-test=\"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "comment"))) + "\">\n        <p class=\"cmp-helloworld__item-label\">Text property:</p>\n        <pre class=\"cmp-helloworld__item-output\" data-cmp-hook-helloworld=\"property\">") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text"), "comment"))) + "</pre>\n    </div>\n    <div class=\"cmp-helloworld__item\" data-sly-use.model=\"com.indusind.aem.platform.core.models.HelloWorldModel\" data-sly-test=\"") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_model, "message"), "comment"))) + "\">\n        <p class=\"cmp-helloworld__item-label\"Kuch Sandesh:</p>\n        <input type=\"text\" placeholder=\"message\">\n        <input type=\"submit\" value=\"Send\">\n        <pre class=\"cmp-helloworld__item-output\"data-cmp-hook-helloworld=\"model\">") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_model, "message"), "comment"))) + "</pre>\n    </div>\n    <img src=\"") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "img"), "comment"))) + "\"><br>\n    ") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title"), "comment"))) + " <br> ANS:  ") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "box"), "comment"))) + " \n</div>-->");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("\n\n\n\n\n<form id=\"createNodeForm\">\n    <label for=\"fname\">First Name:</label>\n    <input type=\"text\" id=\"fname\" name=\"fname\"/>\n      <br/>\n        <label for=\"lname\">Last Name:</label>\n        <input type=\"text\" id=\"lname\" name=\"lname\"/>\n          <br/>\n            <button type=\"button\" onclick=\"saveData()\">Submit</button>\n          </form>\n  \n  \n          <script>\n        debugger;\n            function saveData() {\n              debugger;\n            var fname = document.getElementById(\"fname\").value;\n       var lastname = document.getElementById(\"lname\").value;\n            debugger;\n  \n            var obj = {\n              \"name\":fname,\n                \"lastname\":lastname\n               };\n  \n            $.ajax({\n              url: \"/bin/custom/nodeservlet\",\n            type: 'POST',\n            data: JSON. stringify(obj),\n            cache: false,\n            contentType: 'application/json',\n            processData: false,\n  \n            success: function(data) {\n  \n  \n              alert(\"success\");\n      },\n            error: function(xhr, status, error) {\n              console.log(\"AJAX request error: \" + error);\n            alert(\"AJAX request error: \" + error);\n      }\n    });\n  };\n          </script>\n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  \n  ");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

