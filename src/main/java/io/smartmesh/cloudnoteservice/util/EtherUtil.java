package io.smartmesh.cloudnoteservice.util;

import io.smartmesh.cloudnoteservice.solidity.Cloudnoteservice;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author Mr ifan/詹奕凡
 * @version 1.0
 * @date 2019/1/4
 */
public class EtherUtil {

    public static Web3j getWeb3j(){
        Web3j web3 = Web3j.build(getHttpService());
        return web3;
    }
    public static HttpService getHttpService(){
        return new HttpService("http://localhost:18545");
    }
    public static Credentials getCredentials(){
        //通过密钥获取账户认证
//        Credentials credentials=Credentials.create("C248B10DD617C9F320046F3A77A8D69D887721A48E79EF4D1F5BAE03324A76F3");
//        String path="C:\\Users\\a212\\Desktop\\Spectrum\\build\\bin\\datadir\\keystore\\UTC--2018-11-16T08-06-14.075326800Z--7ebd45969b9ff3ee5bf9496fb6cd01df835ff31d";
        String path="/root/.spectrum/testnet/keystore/UTC--2018-12-22T00-59-50.174797462Z--c596e681659cb199b2d8834132509355a5c7f74c";
        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials("123",path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        return credentials;
    }
    public static Cloudnoteservice getContract(){
        RemoteCall<Cloudnoteservice> deploy = null;
        Cloudnoteservice cloudnoteservice = null;
        try {
//            cloudnoteservice =
//                    Cloudnoteservice.load
//                            ("0xb2172012Bc7f93391c218AF2861A05C0aD57bd75",getWeb3j(),getCredentials(),getPrice(getWeb3j()), BigInteger.valueOf(80_000));
//            cloudnoteservice = Cloudnoteservice.load
//                    ("0xb2172012Bc7f93391c218AF2861A05C0aD57bd75",getWeb3j(),transactionManager,getPrice(getWeb3j()),BigInteger.valueOf(80_000));
            TransactionManager transactionManager = new RawTransactionManager(
                    getWeb3j(), getCredentials(), (byte)3);
            //正确的smt连接方式
//            cloudnoteservice = Cloudnoteservice.load
//                    ("0xe345ae1404ab8fd58d00110886116574bcf1e885",getWeb3j(),transactionManager,getPrice(getWeb3j()),BigInteger.valueOf(80_000));//            cloudnoteservice = Cloudnoteservice.load
//            cloudnoteservice = Cloudnoteservice.load
//                    ("0xebb87d494712e8f167d597086c9cb7cf320248af",getWeb3j(),transactionManager,getPrice(getWeb3j()),BigInteger.valueOf(80_000));
            cloudnoteservice = Cloudnoteservice.load
                    ("0xc53f132fc478d8339a876341d45e8aa031379661",getWeb3j(),transactionManager,getPrice(getWeb3j()),BigInteger.valueOf(80_000));
            System.out.println("cloudnoteservice.getContractAddress()="+cloudnoteservice.getContractAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloudnoteservice;
    }
    public static BigInteger getPrice(Web3j web3j) throws Exception{
        EthGasPrice send = web3j.ethGasPrice().send();
        BigInteger gasPrice = send.getGasPrice();
        return gasPrice;
    }
}
