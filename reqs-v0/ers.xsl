<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
<body>
<xsl:apply-templates/> 
</body>
</html>
</xsl:template>

<xsl:template match="ers">
<p>
<span style="color:black; font-family:arial; font-size:20; font-weight:bold; ">
<xsl:value-of select="@nome"/>                                       
</span>
<xsl:apply-templates select="uc"/>
</p>
</xsl:template>

<xsl:template match="uc">
<p>
<hr/>
<xsl:apply-templates select="@nome"/> 
<xsl:apply-templates select="resumo"/>
</p>
</xsl:template>

<xsl:template match="@nome">
<span style="color:#ff0000; font-family:verdana;">
<xsl:value-of select="."/></span>
<br />
</xsl:template>

<xsl:template match="resumo">
<span style="color:#000000; font-family:verdana; font-size:12; ">
<xsl:value-of select="."/></span>
<br />
</xsl:template>

</xsl:stylesheet> 
