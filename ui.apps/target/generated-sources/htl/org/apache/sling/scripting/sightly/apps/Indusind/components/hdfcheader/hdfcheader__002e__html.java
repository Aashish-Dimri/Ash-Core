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
package org.apache.sling.scripting.sightly.apps.Indusind.components.hdfcheader;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class hdfcheader__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<script>\n    document.addEventListener('DOMContentLoaded', function () {\n        var headerNamespace = {};  // Unique namespace for the header component\n        headerNamespace.init = function () {\n            var urlParams = new URLSearchParams(window.location.search);\n            var cCode = urlParams.get('cCode');\n            var bCode = urlParams.get('bCode');\n            var xhr = new XMLHttpRequest();\n\n            xhr.open('GET', '/bin/custom/hello?cCode=' + encodeURIComponent(cCode) + '&bCode=' + encodeURIComponent(bCode), true);\n            xhr.onreadystatechange = function () {\n                if (xhr.readyState === XMLHttpRequest.DONE) {\n                    if (xhr.status === 200) {\n                        var contentType = xhr.getResponseHeader('Content-Type');\n                        if (contentType && contentType.includes('application/json')) {\n                            try {\n                                var response = JSON.parse(xhr.responseText);\n                                headerNamespace.displayResults(response);\n                            } catch (e) {\n                                console.error('Error parsing JSON:', e);\n                            }\n                        } else {\n                            console.log('Non-JSON response:', xhr.responseText);\n                        }\n                    } else {\n                        console.error('Error:', xhr.status, xhr.statusText);\n                    }\n                }\n            };\n\n            xhr.onerror = function () {\n                console.error('Request failed');\n            };\n\n            xhr.send();\n        };\n\n        headerNamespace.displayResults = function (response) {\n            var logoImage = document.querySelector('.logo2');\n            if (response.bassFlow) {\n                logoImage.src = response.logo;\n            } else {\n                console.error('No valid bass code match');\n            }\n        };\n\n        headerNamespace.init(); // Initialize the header component script\n    });\n</script>\n\n\n<img src=\"/content/dam/HDFCSavingsUnifiedURL/banners/logo.svg\" alt=\"logo1\"/>\n<img class=\"logo2\" src=\"\"/>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

