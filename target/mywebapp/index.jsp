<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
    <body>
    <!DOCTYPE html>
    <html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta charset="utf-8">
        <title>first web - page</title>
        <style>
            <%@include file="/WEB-INF/Stylesheet/School.css" %>
        </style>
    </head>
    <body>
    <div class="cap">
        <header class="cod" >
            <p>Coding</p>
        </header>
    </div>
    <div class="side">
        <aside>
            <ul>
                <li>Thailand</li>
                <li>Laos</li>
                <li>Vietnam</li>
                <li>Singapore</li>
                <li>Honkong</li>
            </ul>
        </aside>
    </div>
    <div class="side2">
        <aside>
            <ul>
                <li>Russia</li>
                <li>Ukaine</li>
                <li>Belarus</li>
                <li>Japan</li>
                <li>South Korea</li>
            </ul>
        </aside>
    </div>
    <main class="divart">
        <article class="article" >
            <h1><span class = "words" >Welcome to my first web - page!<br> Today we will talk about Thailand</span></h1>
            <p><span class="words">BANGKOK</span> — Capping a year of national mourning, Thailand will cremate its celebrated King Bhumibol Adulyadej on Thursday<br>
                evening, in a <span class="words">$90 million</span> ceremony that symbolizes both the bountiful devotion of his subjects and the earthly <br>
                abundance of what many consider the world’s wealthiest monarchy.</p>

            <p>After 10 months of construction, a 164-foot-high royal pyre and pavilion — decorated with nine gilded spires,<br>
                a great white umbrella and statuary of the king’s favorite pet dogs — awaits the funerary urn and coffin in which<br>
                the ninth monarch of the Chakri dynasty has been placed.</p>
        </article>
        <div class="fclass">
            <select class="select" name="slist1" onchange="SList.getSelect('slist2', this.value);">
                <option >Schools</option>
                <option value="SPS">Satri Phatthalung School</option>
                <option value="PS">Phatthalung School</option>
                <option value="AnS" >Anuban School</option>
                <option value="BTS">Ban Thamirum School</option>
                <option value="BBSS" >Ban Bo Sai School</option>
                <option value="PCS" >Phatthalung Christian School</option>
                <option value="PpS" >Phatthalungpittayakom School</option>
            </select>
        </div>

        <!-- Tags for the seccond dropdown list, and for text-content -->
        <span class="spanClass" id="slist2"></span> <div class="innerDiv" id="scontent"></div>

        <script><!--
        /* Script Double Select Dropdown List, from: coursesweb.net/javascript/ */
        var SList = new Object();             // JS object that stores data for options

        // HERE replace the value with the text you want to be displayed near Select
        var txtsl2 = '<span class="lala">Classes</span>';

        /*
         Property with options for the Seccond select list
         The key in this object must be the same with the values of the options added in the first select
         The values in the array associated to each key represent options of the seccond select
        */
        SList.slist2 = {
            "SPS": ['class-1'],
            "PS": ['class-2'],
            "AnS":['class-3'],
            "BTS":['class-4'],
            "BBSS":['class-5'],
            "PCS":['class-6'],
            "PpS":['class-7']
        };

        /*
         Property with text-content associated with the options of the 2nd select list
         The key in this object must be the same with the values (options) added in each Array in "slist2" above
         The values of each key represent the content displayed after the user selects an option in 2nd dropdown list
        */
        SList.scontent = {
            "class-1": 'Matthayom-1, Matthayom-2, Matthayom-3, Matthayom-4, Matthayom-5',
            "class-2": 'Phatthalung-2, Phatthalung-3, Phatthalung-4, Phatthalung-5',
            "class-3": 'Anuban-3, Anuban-4, Anuban-5, Anuban-6, Anuban-7',
            "class-4": 'Thamirum-4, Thamirum-5, Thamirum-6, Thamirum-7, Thamirum-8',
            "class-5": 'Ban Sai-5, Ban Sai-6, Ban Sai-7, Ban Sai-8',
            "class-6": 'Christian-6, Christian-7,Christian-8, Christian-9, Christian-10',
            "class-7": 'Pittayakom-7, Pittayakom-8, Pittayakom-9, Pittayakom-10, Pittayakom-11'
        };

        /* From here no need to modify */

        // function to get the dropdown list, or content
        SList.getSelect = function(slist, option) {
            alert(slist + ' ' + option);
            document.getElementById('scontent').innerHTML = '';           // empty option-content

            if(SList[slist][option]) {
                // if option from the last Select, add text-content, else, set dropdown list
                alert(SList[slist][option]);
                if(slist == 'scontent') document.getElementById('scontent').innerHTML = SList[slist][option];
                else if(slist == 'slist2') {
                    var addata = '<option>Classes</option>';
                    for(var i=0; i<SList[slist][option].length; i++) {
                        alert(SList[slist][option][i]);
                        addata += '<option value="'+SList[slist][option][i]+'">'+SList[slist][option][i]+'</option>';
                    }

                    document.getElementById('slist2').innerHTML = txtsl2+' <select name="slist2" onchange="SList.getSelect(\'scontent\', this.value);">'+addata+'</select>';
                }
            }
            else if(slist == 'slist2') {
                // empty the tag for 2nd select list
                document.getElementById('slist2').innerHTML = '';
            }
        }
        --></script>м
        </main>


    <div class="DataBase">
    <ul>
        <li><a href = "" > Schools </a></li>
        <li><a href = "<c:url value="${requestScope.url }"></c:url>"> Students </a></li>
        <li><a href = "" > Employees </a></li>
    </ul>
    </div>


    <div class="shoes">
        <footer class="new" >
            rasulov1992@mail.ru
        </footer>
    </div>
    </body>
    </html>
    </body>
</html>
