
package it.univaq.webmarket.framework.data;

/**
 *
 * @author abdrahimzeno
 * @param <KT>
 */
public interface DataItem<KT> {

    KT getKey();

    long getVersion();

    void setKey(KT key);

    void setVersion(long version);

}
