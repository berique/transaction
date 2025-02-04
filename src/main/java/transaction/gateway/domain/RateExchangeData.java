package transaction.gateway.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateExchangeData {
    @JsonProperty("record_date")
    private String recordDate;

    @JsonProperty("country")
    private String country;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("country_currency_desc")
    private String countryCurrencyDesc;

    @JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;

    @JsonProperty("effective_date")
    private String effectiveDate;

    @JsonProperty("src_line_nbr")
    private String srcLineNbr;

    @JsonProperty("record_fiscal_year")
    private String recordFiscalYear;

    @JsonProperty("record_fiscal_quarter")
    private String recordFiscalQuarter;

    @JsonProperty("record_calendar_year")
    private String recordCalendarYear;

    @JsonProperty("record_calendar_quarter")
    private String recordCalendarQuarter;

    @JsonProperty("record_calendar_month")
    private String RecordCalendarMonth;

    @JsonProperty("record_calendar_day")
    private String recordCalendarDay;

    public String getCountryCurrencyDesc() {
        return countryCurrencyDesc;
    }

    public void setCountryCurrencyDesc(String countryCurrencyDesc) {
        this.countryCurrencyDesc = countryCurrencyDesc;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getSrcLineNbr() {
        return srcLineNbr;
    }

    public void setSrcLineNbr(String srcLineNbr) {
        this.srcLineNbr = srcLineNbr;
    }

    public String getRecordFiscalYear() {
        return recordFiscalYear;
    }

    public void setRecordFiscalYear(String recordFiscalYear) {
        this.recordFiscalYear = recordFiscalYear;
    }

    public String getRecordFiscalQuarter() {
        return recordFiscalQuarter;
    }

    public void setRecordFiscalQuarter(String recordFiscalQuarter) {
        this.recordFiscalQuarter = recordFiscalQuarter;
    }

    public String getRecordCalendarYear() {
        return recordCalendarYear;
    }

    public void setRecordCalendarYear(String recordCalendarYear) {
        this.recordCalendarYear = recordCalendarYear;
    }

    public String getRecordCalendarQuarter() {
        return recordCalendarQuarter;
    }

    public void setRecordCalendarQuarter(String recordCalendarQuarter) {
        this.recordCalendarQuarter = recordCalendarQuarter;
    }

    public String getRecordCalendarMonth() {
        return RecordCalendarMonth;
    }

    public void setRecordCalendarMonth(String recordCalendarMonth) {
        RecordCalendarMonth = recordCalendarMonth;
    }

    public String getRecordCalendarDay() {
        return recordCalendarDay;
    }

    public void setRecordCalendarDay(String recordCalendarDay) {
        this.recordCalendarDay = recordCalendarDay;
    }
}
