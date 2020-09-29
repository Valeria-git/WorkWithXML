<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:book="http://bsuir.by/Bookshop"
                version="1.0">
    <xsl:template match="/">

        <html>
            <head>
                <style type="text/css">
                    table.tfmt {
                    border: 1px ;
                    }

                    td.colfmt {
                    border: 1px ;
                    background-color: white;
                    color: black;
                    text-align:right;
                    }

                    th {
                    background-color: #2E9AFE;
                    color: white;
                    }

                </style>
            </head>

            <body>
                <table class="tfmt">
                    <tr>
                        <th style="width:350px">Product Name:</th>
                        <th style="width:250px">Author:</th>
                        <th style="width:250px">Genre:</th>
                        <th style="width:250px">Price:</th>
                    </tr>

                    <xsl:for-each select="book:books/book:books">
                        <xsl:sort select="book:production"/>
                        <tr>
                            <td class="colfmt">
                                <xsl:value-of select="book:name"/>
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="book:author"/>
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="book:genre"/>
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="book:price"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
