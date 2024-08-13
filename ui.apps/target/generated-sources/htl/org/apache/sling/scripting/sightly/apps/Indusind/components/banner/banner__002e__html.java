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
package org.apache.sling.scripting.sightly.apps.Indusind.components.banner;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class banner__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_banner = null;
out.write("<style>\n  \n    .cmp-banner-section {\n      width: 100%;\n      background-size: 100% 100%;\n      background-position: center;\n      background-image:url(\"/content/dam/HDFCSavingsUnifiedURL/banners/480x140.jpg\");\n      height: 120px;\t\n    }\n    @media (min-width: 480px) {\n      .cmp-banner-section {\n\t    background-image:url(\"/content/dam/HDFCSavingsUnifiedURL/banners/320x120.jpg\");\n        height: 140px;\t\n\t  }\n    }\n    @media (min-width: 768px) {\n      .cmp-banner-section {\n\t    background-image:url(\"/content/dam/HDFCSavingsUnifiedURL/banners/716x298.jpg\");\n        height: 160px;\t\n\t  }\n    }\n    @media (min-width: 992px) {\n      .cmp-banner-section {\n\t    background-image:url(\"/content/dam/HDFCSavingsUnifiedURL/banners/1440x200.jpg\");\n        height: 200px;\t\n\t  }\n    }\n  \n</style>\n\n");
_global_banner = renderContext.call("use", "banner.js", obj());
{
    boolean var_unwrapcondition0 = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_banner, "linkUrl")));
    if (!var_unwrapcondition0) {
        out.write("<a class=\"cmp-image__link\"");
        {
            Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_banner, "linkUrl");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "uri");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" href");
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
        {
            boolean var_attrvalue5 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_banner, "data")) ? true : false);
            {
                Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                {
                    boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (false != var_attrvalue5)));
                    if (var_shoulddisplayattr8) {
                        out.write(" data-cmp-clickable");
                        {
                            boolean var_istrueattr7 = (var_attrvalue5 == true);
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
        out.write(" data-cmp-hook-image=\"linkUrl\" target=\"_blank\">");
    }
    out.write("\n       <div class=\"cmp-banner-section\"></div>");
    {
        String var_9 = (("\n       " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_banner, "linkUrl"), "text"))) + "\n");
        out.write(renderContext.getObjectModel().toString(var_9));
    }
    if (!var_unwrapcondition0) {
        out.write("</a>");
    }
}
out.write("\n\n<script>\n    document.addEventListener('DOMContentLoaded', function () {\n        var urlParams = new URLSearchParams(window.location.search);\n        var cCode = urlParams.get('cCode');\n        var bCode = urlParams.get('bCode');\n        var xhr = new XMLHttpRequest();\n        \n        xhr.open('GET', '/bin/custom/hello?cCode=' + encodeURIComponent(cCode) + '&bCode=' + encodeURIComponent(bCode), true);\n        xhr.onreadystatechange = function () {\n        \n            if (xhr.readyState === XMLHttpRequest.DONE) {\n                if (xhr.status === 200) {\n                    var contentType = xhr.getResponseHeader('Content-Type');\n                    if (contentType && contentType.includes('application/json')) {\n                      \n                      try {\n                            var response = JSON.parse(xhr.responseText);\n                            displayResults(response);\n                        } catch (e) {\n                            console.error('Error parsing JSON:', e);\n                        }\n                    } else {\n                        console.log('Non-JSON response:', xhr.responseText);\n                    }\n                } else {\n                    console.error('Error:', xhr.status, xhr.statusText);\n                }\n            }\n        };\n\n        xhr.onerror = function () {\n            console.error('Request failed');\n        };\n\n        xhr.send();\n    });\n    function displayResults(response) {\n        if (response.bassFlow) {\n        \tconsole.log(\"RESPONSE\" + response);\n            var bannerSection = document.querySelector('.cmp-banner-section');\n            bannerSection.style.backgroundImage = 'url(' + response.webfile + ')';\n            bannerSection.style.height = '200px';\n        } else {\n        \tconsole.log(\"RESPONSE\" + response);\n            console.error('No valid bass code match');\n        }\n    }\n</script>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

