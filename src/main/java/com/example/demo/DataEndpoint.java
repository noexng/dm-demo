package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.data_mobile.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigDecimal;
import java.util.Objects;

@Endpoint
public class DataEndpoint {
    private static final String NAMESPACE_URI = "http://www.data-mobile.ru";

    private DatatypeFactory datatypeFactory;

    @Autowired
    public DataEndpoint() {
        try {
            this.datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private DMTemplate getTestTemplate() {
        DMTemplate template = new DMTemplate();

        template.setDMTemplateID(123);
        template.setDMIsMark(false);
        template.setDMTemplateName("Приёмка");
        template.setDMEnableNew(false);
        template.setDMLoadArtsWithRows(false);
        template.setDMLoadRowsOnOpen(true);

        template.setDMDisableManualChangeClient(true);
        template.setDMDisableReaderChangeClient(true);
        template.setDMreaderTrack1Use(false);
        template.setDMreaderTrack2Use(false);
        template.setDMreaderTrack3Use(false);

        template.setDMnewPackOnWS(false);
        template.setDMuseBCTemplates(false);
        template.setDMuseSelectLogAsInsertTask(false);
        template.setDMonUploadIncorrectDoc(1);
        template.setDMuseArtInsert(false);
        template.setDMuseAllBarcode(false);

        template.setDMuseSelect(true);
        template.setDMonArtScanSelect(0); // ???
        template.setDMonTaskQtySelect(2);
        template.setDMonLimitQtySelect(0);
        template.setDMuseCellSelect(0);
        template.setDMuseSNSelect(2); // ???
        template.setDMusePackSelect(0);
        template.setDMuseCellOnTaskSelect(false);
        template.setDMuseSNOnTaskSelect(true); // ???
        template.setDMquantEnableSelect(true);
        template.setDMenterToCommitSelect(true);
        template.setDMwriteRecordToWSSelect(false);

        template.setDMuseInsert(false);
        template.setDMonArtScanInsert(0);
        template.setDMonTaskQtyInsert(0);
        template.setDMonLimitQtyInsert(0);
        template.setDMuseCellInsert(0);
        template.setDMuseSNInsert(0);
        template.setDMusePackInsert(0);
        template.setDMuseCellOnTaskInsert(false);
        template.setDMuseSNOnTaskInsert(false);
        template.setDMquantEnableInsert(false);
        template.setDMenterToCommitInsert(false);
        template.setDMwriteRecordToWSInsert(false);

        template.setDMPrintLabelInsert(0);
        template.setDMPrintLabelSelect(0);
        template.setDMonNewArt(0);
        template.setDMoneArtReplaceMode(false);
        template.setDMuniquebarcodedoc(true); // ???

        template.setDMMultiDoc(false);
        template.setDMMultiDocSound(false);
        template.setDMMultiDocTimeout(0);

        template.setDMEnterCellSelect(0);
        template.setDMEnterCellInsert(0);

        template.setUsePhotofixationSelect(false);
        template.setUsePhotofixationInsert(false);

        template.setDMUseEgais(false);
        template.setDMUseDataMatrixBarcode(0);
        template.setDMUseDateBottling(false);
        template.setDMEnterPDF417Barcode(0);
        template.setDMEgaisCompare(false);
        template.setDMUseBlankA(0); // EGAIS
        template.setDMUseBlankB(0); // EGAIS

        template.setDMGetCellsListFromServerSelect(false);
        template.setDMGetCellsListFromServerInsert(false);

        template.setDMUseCheckMark(false); // EGAIS

        template.setDMIsUniqueSNSelect(false); // ???
        template.setDMIsUniqueSNInsert(false);

        template.setDMEgaisVersion(0);
        template.setDMGetDateBottlingFromServer(false);

        template.setDMUseOnlineArtsCatalog(false);

        template.setDMAlertNewDoc(true);
        template.setDMUseMark(false);
        template.setDMNoScanArts(false);
        template.setDMNoScanCells(false);

        template.setDMSNTypeInsert(null);
        template.setDMSNRulesInsert(null);
        template.setDMSNNotNullSelect(false);
        template.setDMFullyCellInsert(false);
        template.setDMFullyCellSelect(false);
        template.setDMSNNotNullInsert(false);
        template.setDMSNTypeSelect(null);
        template.setDMSNRulesSelect(null);

        return template;
    }

    private DMBarcode getTestBarcode() {
        DMBarcode barcode = new DMBarcode();
        barcode.setDMBarcode("33333");
        barcode.setDMMeasureName("шт");
        barcode.setDMMeasureK(new BigDecimal("7.62"));
        barcode.setDMisMark(false);
        barcode.setDMUseSN(0);

        return barcode;
    }

    private DMBarcode getTestBarcode2() {
        DMBarcode barcode = new DMBarcode();
        barcode.setDMBarcode("66666");
        barcode.setDMMeasureName("кг");
        barcode.setDMMeasureK(new BigDecimal("1"));
        barcode.setDMisMark(false);
        barcode.setDMUseSN(0);

        return barcode;
    }

    private DMArt getTestArt() {
        DMArt art = new DMArt();

        art.setDMArtName("Материал тест");
        art.setDMArtID("123");
        art.setDMArtAttr1("aaa");
        art.setDMArtAttr2("bbb");
        art.setDMArtPrice(new BigDecimal("0"));
//        art.setDMBarcodeList([
//            this.setgetTestBarcode(),
//            this.setgetTestBarcode2(),
//        ]);
        art.setDMisMark(false);
        art.setDMArtAttr2(null);
        art.setDMArtAttr3(null);
        art.setDMArtAttr4(null);
        art.setDMArtAttr5(null);
        art.setDMArtAttr6(null);
        art.setDMArtAttr7(null);
        art.setDMArtAttr8(null);
        art.setDMArtAttr9(null);
        art.setDMArtAttr10(null);
        art.setDMUseSN(true);
        art.setDMWeightTask(null);

        return art;
    }

    private DMArtQueryItem getTestArtQueryItem(DMArt art, DMBarcode barcode) {
        DMArtQueryItem item = new DMArtQueryItem();

        item.setDMArtName(art.getDMArtName());
        item.setDMArtID(art.getDMArtID());
        item.setDMArtPrice(art.getDMArtPrice());
        item.setDMArtAttr1(art.getDMArtAttr1());
        item.setDMArtAttr2(art.getDMArtAttr2());

        item.setDMMeasureName(barcode.getDMMeasureName());
        item.setDMMeasureK(barcode.getDMMeasureK());

        item.setDMTaskQnt(new BigDecimal("7.62"));
        item.setDMLimitQnt(new BigDecimal("0"));

        item.setDMArtAttr3(art.getDMArtAttr3());
        item.setDMArtAttr4(art.getDMArtAttr4());
        item.setDMArtAttr5(art.getDMArtAttr5());
        item.setDMArtAttr6(art.getDMArtAttr6());
        item.setDMArtAttr7(art.getDMArtAttr7());
        item.setDMArtAttr8(art.getDMArtAttr8());
        item.setDMArtAttr9(art.getDMArtAttr9());
        item.setDMArtAttr10(art.getDMArtAttr10());

        item.setDMUseSN(art.isDMUseSN());
        item.setDMBarcodeUseSN(barcode.getDMUseSN());

        return item;
    }

    private DMClient getTestClient() {
        DMClient client = new DMClient();

        client.setDMName("ООО Ромашка");
        client.setDMClientID("123");
        client.setDMBarcode("123");

        return client;
    }

    private DMWarehouse getTestWarehouse() {
        DMWarehouse warehouse = new DMWarehouse();

        warehouse.setDMWarehouseID("123");
        warehouse.setDMWarehouseName("Тестовый склад");

        return warehouse;
    }

    private DMDocHead getTestDocHead() {
        DMDocHead doc = new DMDocHead();

        doc.setDMDocOutID("12345");
        doc.setDMNumber("1.23-45");
        doc.setDMDate(this.datatypeFactory.newXMLGregorianCalendar("2019-09-01T00:00:00"));
        doc.setDMComment("Например");
        doc.setDMBarcode("111222333");
        doc.setDMTemplate(this.getTestTemplate());
        doc.setDMisMark(false);
        doc.setDMisLoaded(false);
        doc.setDMClient(this.getTestClient());
        doc.setDMClientSelectDate(null);
//        doc.setDMWarehouse(this.getTestWarehouse());
//        doc.setDMWarehouse2("123");

        return doc;
    }

    private DMDocRec getTestDocRec() {
        DMDocRec rec = new DMDocRec();

        DMArt art = this.getTestArt();

        rec.setDMBarcode("1234567890");
        rec.setDMSN("12345");
        rec.setDMCell(null);
        rec.setDMArtID(art.getDMArtID());
        rec.setDMPackID(null);
        rec.setDMQuant(new BigDecimal("7.62"));
        rec.setDMArtName(art.getDMArtName());
        rec.setDMLimit(new BigDecimal("0"));
        rec.setDMPDFBarcode(null);
        rec.setDMDataMatrixBarcode(null);
        rec.setDMDateBottling(null);
        rec.setDMRowID(1);
        rec.setDMDecodedPDFBarcode(null);
        rec.setDMBlankA(null);
        rec.setDMBlankB(null);
        rec.setDMRFIDTagID(null);
        rec.setDMChangedPrice(new BigDecimal(0));
        rec.setDMBoxPackID(null);
        rec.setDMTable(null);
        rec.setDMArtEgaisID(null);
        rec.setDMPrice(new BigDecimal(0));
        rec.setDMDate(this.datatypeFactory.newXMLGregorianCalendar("2019-09-20T00:00:00"));
        rec.setDMGroupId(null);
        rec.setDMWeightTask(art.getDMWeightTask());

        return rec;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IsNewData")
    @ResponsePayload
    public IsNewDataResponse isNewData(@RequestPayload IsNewData request)
    {
        IsNewDataResponse response = new IsNewDataResponse();

        DMNewDataStruct dmNewData = new DMNewDataStruct();
        response.setReturn(dmNewData);

        dmNewData.setDMClearArts(true);
        dmNewData.setDMClearCells(false);
        dmNewData.setDMClearTemplates(true);
        dmNewData.setDMClearUsers(false);
        dmNewData.setDMClearDocs(true);
        dmNewData.setDMClearClients(false);
        dmNewData.setDMClearUnits(false);
        dmNewData.setDMClearEgaisArts(false);
        dmNewData.setDMClearWarehouses(false);
        dmNewData.setDMClearEgaisMarks(false);

        dmNewData.setDMNewArts(true);
        dmNewData.setDMNewCells(false);
        dmNewData.setDMNewTemplates(true);
        dmNewData.setDMNewUsers(false);
        dmNewData.setDMNewDocs(true);
        dmNewData.setDMNewClients(false);
        dmNewData.setDMNewUnits(false);
        dmNewData.setDMNewEgaisArts(false);
        dmNewData.setDMNewWarehouses(false);
        dmNewData.setDMNewEgaisMarks(false);

        dmNewData.setDMClearTemplatesEGAIS(false);
        dmNewData.setDMNewTemplatesEGAIS(false);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTemplates")
    @ResponsePayload
    public GetTemplatesResponse getTemplates(@RequestPayload GetTemplates request) {
        GetTemplatesResponse response = new GetTemplatesResponse();

        DMTemplateList templateList = new DMTemplateList();
        response.setReturn(templateList);

        DMTemplate template = this.getTestTemplate();
        templateList.getDMTemplate().add(template);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetArtAttributesName")
    @ResponsePayload
    public GetArtAttributesNameResponse getArtAttributesName(@RequestPayload GetArtAttributesName request) {
        GetArtAttributesNameResponse response = new GetArtAttributesNameResponse();

        response.setReturn(new DMAttrs());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetArtRest")
    @ResponsePayload
    public GetArtRestResponse getArtRest(@RequestPayload GetArtRest request) {
        GetArtRestResponse response = new GetArtRestResponse();

        response.setReturn(new BigDecimal("0"));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDocArts")
    @ResponsePayload
    public GetDocArtsResponse getDocArts(@RequestPayload GetDocArts request) {
        GetDocArtsResponse response = new GetDocArtsResponse();

        DMArtList artList = new DMArtList();
        response.setReturn(artList);

        artList.getDMArt().add(this.getTestArt());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDocHeads")
    @ResponsePayload
    public GetDocHeadsResponse getDocHeads(@RequestPayload GetDocHeads request) {
        GetDocHeadsResponse response = new GetDocHeadsResponse();

        DMDocList docList = new DMDocList();
        response.setReturn(docList);

        docList.getDMDocHead().add(this.getTestDocHead());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDocRowsInsert")
    @ResponsePayload
    public GetDocRowsInsertResponse getDocRowsInsert(@RequestPayload GetDocRowsInsert request) {
        GetDocRowsInsertResponse response = new GetDocRowsInsertResponse();

        DMDocRows rows = new DMDocRows();
        response.setReturn(rows);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDocRowsSelect")
    @ResponsePayload
    public GetDocRowsSelectResponse getDocRowsSelect(@RequestPayload GetDocRowsSelect request) {
        GetDocRowsSelectResponse response = new GetDocRowsSelectResponse();

        DMDocRows rows = new DMDocRows();
        response.setReturn(rows);

        DMDocHead testDocHead = this.getTestDocHead();

        if (Objects.equals(request.getDocOutID(), testDocHead.getDMDocOutID())) {
            rows.getDMDocRow().add(this.getTestDocRec());
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetNewArts")
    @ResponsePayload
    public GetNewArtsResponse getNewArts(@RequestPayload GetNewArts request) {
        GetNewArtsResponse response = new GetNewArtsResponse();

        DMArtList artList = new DMArtList();
        response.setReturn(artList);

        artList.getDMArt().add(this.getTestArt());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "OnArtScanSelect")
    @ResponsePayload
    public OnArtScanSelectResponse onArtScanSelect(@RequestPayload OnArtScanSelect request) {
        OnArtScanSelectResponse response = new OnArtScanSelectResponse();

        DMArtQueryInfo info = new DMArtQueryInfo();
        response.setReturn(info);

        info.getDMArtQueryItem(); // init

        DMDocHead testDocHead = this.getTestDocHead();

        if (Objects.equals(request.getDocOutID(), testDocHead.getDMDocOutID())) {
            DMBarcode barcode = this.getTestBarcode();

            if (Objects.equals(request.getBarcode(), barcode.getDMBarcode())) {
                info.getDMArtQueryItem().add(this.getTestArtQueryItem(this.getTestArt(), barcode));
            }
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "OnPalletScan")
    @ResponsePayload
    public OnPalletScanResponse onPalletScan(@RequestPayload OnPalletScan request)
    {
        OnPalletScanResponse response = new OnPalletScanResponse();

        DMArtQueryInfoUPL info = new DMArtQueryInfoUPL();
        response.setReturn(info);

        info.getDMArtQueryItemUPL(); // init

        DMDocRec rec = this.getTestDocRec();

        if (Objects.equals(request.getBarcode(), rec.getDMPackID())) {
            DMArtQueryItemUPL item = new DMArtQueryItemUPL();
            info.getDMArtQueryItemUPL().add(item);

            DMArt art = this.getTestArt();
            DMBarcode barcode = this.getTestBarcode();

            item.setDMArt(art);
            item.setDMBarcode(barcode);
            item.setDMQty(rec.getDMQuant());
            item.setDMSN(rec.getDMSN());
            item.setDMCell(rec.getDMCell());
            item.setDMPack(rec.getDMPackID());
            item.setDMBoxPack(rec.getDMBoxPackID());
            item.setDMPDFBarcode(rec.getDMPDFBarcode());
            item.setDMDecodedPDFBarcode(rec.getDMDecodedPDFBarcode());
            item.setDMDataMatrixBarcode(rec.getDMDataMatrixBarcode());
            item.setDMDateBottling(rec.getDMDateBottling());
            item.setDMBlankA(rec.getDMBlankA());
            item.setDMBlankB(rec.getDMBlankB());
            item.setDMIsCompared(null);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "OnWriteRecSelect")
    @ResponsePayload
    public OnWriteRecSelectResponse onWriteRecSelect(@RequestPayload OnWriteRecSelect request)
    {
        OnWriteRecSelectResponse response = new OnWriteRecSelectResponse();

        response.setReturn(true);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendLogs")
    @ResponsePayload
    public SendLogsResponse sendLogs(@RequestPayload SendLogs $request)
    {
        SendLogsResponse response = new SendLogsResponse();

        response.setReturn(true);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "WriteDoc")
    @ResponsePayload
    public WriteDocResponse writeDoc(@RequestPayload WriteDoc $request)
    {
        WriteDocResponse response = new WriteDocResponse();

        response.setReturn(true);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Login")
    @ResponsePayload
    public LoginResponse login(@RequestPayload Login $request)
    {
        LoginResponse response = new LoginResponse();

        response.setReturn(true);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Logout")
    @ResponsePayload
    public LogoutResponse logout(@RequestPayload Logout $request)
    {
        LogoutResponse response = new LogoutResponse();

        response.setReturn(true);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DMServerInfo")
    @ResponsePayload
    public DMServerInfoResponse dmServerInfo(@RequestPayload DMServerInfo request) {
        DMServerInfoResponse response = new DMServerInfoResponse();

        response.setReturn("OK");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetVersion")
    @ResponsePayload
    public GetVersionResponse getVersion(@RequestPayload GetVersion request) {
        GetVersionResponse response = new GetVersionResponse();
        
        response.setReturn("2.6");

        return response;
    }
}
