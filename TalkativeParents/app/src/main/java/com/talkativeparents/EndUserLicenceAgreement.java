package com.talkativeparents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by Raghunandan on 13-02-2016.
 */
public class EndUserLicenceAgreement extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_user_license_agreement);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.my_awesome_toolbar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("End User License Agreement");

        Button accept = (Button) findViewById(R.id.accept);
        accept.setOnClickListener(this);

        Button reject = (Button) findViewById(R.id.reject);
        reject.setOnClickListener(this);

        WebView webView = (WebView)findViewById(R.id.eula);

        webView.setBackgroundColor(Color.TRANSPARENT);
        //webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        webView.loadUrl("file:///android_asset/eula.html");
        StringBuilder sb = new StringBuilder ();
        sb.append ("<html><body><style type=\"text/css\">@font-face{font-family:'Roboto';src:url(\"file:///android_asset/Roboto/Roboto-Medium.ttf\")}p{font-family:'Roboto';font-size:"+"fontSize"+"px;text-align:justify;}</style><p>");
        sb.append ("Attention: this is a license, not a sale. The talkative parents<sup>TM</sup> software application product is available to download for parents under the following end user license agreement (\"EULA\") and all applicable addenda which define what you may do with the product and contains limitations on warranties and/or remedies.");
        sb.append ("</br></br>This license is granted by talkative solutions private limited and includes the following:");
        sb.append ("</br></br>This EULA is a legally binding contract that should be read in its entirety. By installing or using this software or any module or portion or feature thereof on clicking accept, you accept all the terms and conditions of this agreement.");
        sb.append ("</br></br>This EULA is a legal agreement between you (the \"Licensee\"), and Talkative Solutions Private Limited or his authorized reseller, in respect of Talkative Parents<sup>TM</sup> (the \"Software\") which may include associated media and \"online\" or electronic documentation (collectively the \"Product\"). The Product also includes any updates and supplements to the original Product as may be provided to you from time to time by the Licensor, subject to the Licensor\'s sole and absolute discretion. The Product does not include new releases to Software. You are subject to the terms and conditions of this EULA whether you access or obtain the Product directly from the Licensor, or through any other source or person or through access to a third party application or platform on which the Software is run through the specific permission of the Licensor of a validly procured license. For purposes hereof, you (and all variations thereof, such as \"your\") means the individual person installing or using the Product on his or her own behalf; this Product is not intended for use by or on behalf of an organization. For purposes hereof the term \"organization\", without limitation, includes any partnership, company, corporation, association of persons, limited liability partnership, joint stock company, trust, joint venture, labor organization, unincorporated organization, or governmental authority.");
        sb.append ("</br></br>By accessing, storing, loading, installing, executing, displaying or copying the Product into the Client Device (as defined hereinafter) or otherwise using the functionality of the Product in accordance with  its documentation (henceforth \"Operating\"), you are deemed to have agreed and to be bound by the terms of this EULA. If you do not agree to the terms and conditions of this EULA, the Licensor is unwilling to license the Product to you.  In such event, you may not Operate or use the Product in any way.");
        sb.append ("</br></br>This Product will not install on the Client Device unless or until you accept the terms of this Agreement. Since this EULA is in electronic form and constitutes an electronic record within the meaning of applicable laws, your acceptance of the terms hereof shall be signified by your clicking on the \"ACCEPT\" button appearing on the window containing this EULA, whereupon you expressly agree to be bound by the terms and conditions of this EULA.");
        sb.append ("</br></br>The Software integrates certain free open source software which have been modified to function along with the Software. All such modifications have been carried out under the terms of the license agreement pertaining to those software. The open source free software that have been modified and distributed along with the Software have been so made in accordance with the terms of their respective license agreements.");
        sb.append ("</br></br>GRANT OF LICENSE");
        sb.append ("</br></br>The Licensor grants you, a perpetual, worldwide, non-exclusive, non-sub-licensable, non-transferable license to store, load, install, execute and access (\"Use\") the specified version of the Software on a single mobile electronic device, or mobile computing platform for which the software was designed (a \"Client Device\") as per this EULA (\"License\").");
        sb.append ("</br></br>You are permitted to install and Use this version of the Product on only one (1) Client Device. The Licensor may, subject to his sole and absolute discretion (and without being obligated to), provide you with updates or upgrades to the Software (\"Updates\"). Use of any Update is subject to the terms of this EULA. By installing or otherwise using any such Update, you agree to be bound by the terms of this EULA with respect to such Update.");
        sb.append ("</br></br> The Licensor may, subject to his sole and absolute discretion (and without being obligated to), provide you with updates or upgrades to the Software (\"Updates\"). Use of any Update is subject to the terms of this EULA. By installing or otherwise using any such Update, you agree to be bound by the terms of this EULA with respect to such Update.");
        sb.append ("</br></br>The Licensor reserves all rights not expressly granted herein.");
        sb.append ("</br></br> PROPRIETARY RIGHTS AND NON-DISCLOSURE.");
        sb.append ("</br></br>You agree that the Product (including any copies thereof) and the authorship, systems, ideas, methods of operation, documentation and other information contained in the Product, including but not limited to any images, photograph, animations, video, audio, music, test, applets and APIs incorporated into the Product and the Software\'s source code, are proprietary intellectual properties of the Licensor and are protected by civil and criminal law, and by the laws of copyright, trade secret, trademark and patent law of India, other countries and international treaties. The Licensor  owns and retains all right, title, and interest in and to the Product including without limitations any error corrections, enhancements, Updates or other modifications to the Software, and all copyrights, patents, trade secret rights, trademarks, and other intellectual property rights therein.");
        sb.append ("</br></br>Your possession, installation or Use of the Product does not transfer to you any title to the intellectual property in the Product, and you will not acquire any rights to the Product except as expressly set forth in this Agreement.");
        sb.append ("</br></br>RESTRICTIONS");
        sb.append ("</br></br>Under no circumstances you shall transfer, rent, lease, lend, copy, modify, translate, adapt, sublicense, sell,  publish, display, distribute, time-share or electronically transmit or receive or otherwise transfer to a third party, the Product, any copy or use thereof, in whole or in part, without the Licensor's prior written consent; provided that if such non-waivable right is specifically granted to you under applicable law in your jurisdiction, you may transfer your rights under this EULA permanently to another person or entity, subject to a) you also transferring this EULA, the Product, and all other software or hardware bundled or pre-installed with the Product, including all copies, Updates and prior versions, to such person or entity; b) retaining no copies, including backups and copies; and c) the receiving party accepting the terms and conditions of this EULA and any other terms and conditions upon which you legally purchased a license to the Product.");
        sb.append ("</br></br>You may not emulate, modify, decompile, disassemble, otherwise reverse engineer, or otherwise reduce any part of the Product to human readable form or transfer the Product, or any subset of the Product, nor permit any third party to do so, except to the extent the foregoing restriction is expressly prohibited by applicable law.  Notwithstanding the foregoing sentence, decompiling the Software is permitted to the extent the laws of your jurisdiction give you the non-waivable right to do so to obtain information necessary to render the Software interoperable with other software; provided, however, that you must first request such information from the Licensor and the Licensor may, in its discretion, either provide such information to you (subject to confidentiality terms) or impose reasonable conditions, including a reasonable fee, on such use of the Software to ensure that the Licensor's proprietary rights in the Software are protected.  You may not modify or create derivative works based upon the Product in whole or in part.  Any such unauthorized use shall result in immediate and automatic termination of this EULA and will result in criminal and/or civil prosecution.  Neither Product's binary code nor source code may be used or reverse engineered to re-create the program algorithm, which is proprietary, without written permission of the Licensor.");
        sb.append ("</br></br>You may not remove any proprietary notices, trademark notices, copyright notices or labels on the Product.");
        sb.append ("</br></br>You may not transfer or assign any of the rights granted to you under this EULA or any of your obligations pursuant here to.");
        sb.append ("</br></br>You agree that, the Product, including the specific design and structure of individual modules constitute confidential proprietary information of the Licensor. You agree not to transfer, copy, disclose, publish, provide or otherwise make available such confidential information in any form to any third party.");
        sb.append ("</br></br>The Software includes components of open source elements which are provided by third parties for use in the run time environment of the Software (\"Third Party Software\") and you hereby acknowledge and agree that the licensor of any such Third Party Software may have a proprietary or community right, title and interest in such Third Party Software. The Licensor does not provide any warranty in relation to such Third Party Software and is not responsible for the performance of such Third Party ");
        sb.append ("</br></br> Nothing in this EULA shall be construed as granting you any rights or licenses with regard to the new releases of the Product or to entitle you to any new release. For the purpose of this EULA, \'new release(s)\' means any improved, modified, upgraded or corrected version of the Software or any Module,  issued from time to time by or on behalf of the Licensor, as providing substantial new features sufficient to be separately priced and launched as a separate software product or module.");
        sb.append ("</br></br>You agree that in Operating the Product and in using any report or information derived as a result of Operating this Product, you will comply with all applicable international, national, state, regional and local laws and regulation, including, without limitation, privacy, copyright, export control and obscenity laws.");
        sb.append ("</br></br>LIMITED WARRANTY");
        sb.append ("</br></br>The Software generally provides no warranty. However, the functionalities of the software will install and are expected in the normal course to work properly without any errors. Licensor is not responsible for any damage or effect for the external applications that integrate with the software.");
        sb.append ("</br></br>NO IMPLIED OR OTHER WARRANTIES");
        sb.append ("</br></br>Except for the foregoing limited warranty and for any warranty, condition, representation or term to the extent to which the same cannot or may not be excluded or limited by law applicable to you in india, the product is provided \"as-is\" without any warranty whatsoever and the licensor makes no promises, representations or warranties, whether expressed or implied, whether by statute, common law, custom, usage or otherwise, regarding or relating to the product or content therein or to any other material furnished or provided to you pursuant to this eula or otherwise. You assume all risks and responsibilities for selection of the product to achieve your intended results, and for the installation of, use of, and results obtained from the product. The licensor makes no warranty that the product will be error free or free from interruption or failure, or that it is compatible with any particular hardware or software or that the software is inter operable with your existing infrastructure. To the maximum extent permitted by applicable law, licensor disclaims all warranties, either express or implied, including but not limited to implied warranties of merchantability, non-infringement of third party rights, integration with your own products, satisfactory quality or fitness for any particular purpose with respect to the product and the accompanying written materials or the use thereof. You hereby acknowledge that the product may not be or become available due to any number of factors including without limitation periodic system maintenance, scheduled or unscheduled, acts of god, technical failure of the software, telecommunications infrastructure, or delay or disruption attributable to viruses, denial of service, attacks, increased or fluctuating demand, and actions and omissions of third parties. Therefore, the licensor expressly disclaims any express or implied warranty regarding system and/or software availability, accessibility, or performance. The licensor disclaims any and all liability for the loss or corruption of data during any installation, execution or communications and any liability arising from or related to any failure by the licensor to transmit accurate or complete information to you.");
        sb.append ("</br></br>NO LIABILITY");
        sb.append ("</br></br> In no event will the Licensor be liable to you for any loss, damages, claims or costs whatsoever, including any special, consequential, indirect or incidental damages, any lost profits or lost savings, lost or corrupt data, loss of privacy, personal injury or failure to meet any duty of care, or claims by a third party arising out of the use or inability or inappropriate use of the Software, even if you have been advised of the possibility of such loss, damages, claims or costs in advance. In any case, the Licensor\'s entire liability under any provision of this EULA shall be limited to amount actually paid by you, pursuant to purchase of the Licensor\'s Product.");
        sb.append ("</br></br>YOUR INFORMATION AND THE LICENSOR'S PRIVACY POLICY");
        sb.append ("</br></br> You hereby expressly consent to the Licensor's processing of your personal data (which may be collected by the Licensor or its resellers or distributors). By entering into this Agreement, you agree that the Licensor may collect and retain information about you, including your name, email address and institute/organization information. The Licensor may employ other companies and individuals to perform certain services and/or functions on its behalf. Examples include selling and marketing the Product, fulfilling orders, delivering packages, sending postal mail and e-mail, removing repetitive information from customer lists, analyzing data, providing marketing assistance and providing customer service. They have access to personal information needed to perform their functions, but may not use it for other purposes.");
        sb.append ("</br></br>TERMINATION");
        sb.append ("</br></br>The Licensor may terminate this EULA by offering you a superseding agreement for the Product or any replacement or modified version of or upgrade or new release of the Product and conditioning your continued use of the Product or such replacement, modified or upgraded version or new release on your acceptance of such superseding agreement. This EULA may be also terminated by the Licensor immediately and without notice if you fail to comply with any of your obligation or conditions of this EULA. Without prejudice to any other rights, this EULA will terminate automatically if you fail to comply with any of the limitations, restrictions or other requirements described herein.   Upon termination of this EULA you will no longer be authorized to operate or use the Product in any way and you must immediately cease use of the Product and destroy all copies of the Product.");
        sb.append ("</br></br>INDEMNIFICATION");
        sb.append ("</br></br>You agree to indemnify, defend and hold harmless Licensor and its respective officers, directors, employees, agents, successors, and assigns from any and all losses, liabilities, damages and claims, and all related expenses (including reasonable legal fees and disbursements and costs of investigation, litigation, settlement, judgment, interest and penalties) and costs related to, arising from, or in connection with any third-party claim related to, arising from, or in connection with the actual or alleged: (i) infringement by Licensee (except when such breach is exclusively attributable to Product) of any third-party intellectual property and/or proprietary right, including, but not limited to, patent, trademark, copyright, trade secret, publicity and/or privacy, (ii) personal injury (including death) or property damage due to the gross negligence or intentional misconduct of Licensee, and/or (iii) breach by Licensee of any of its representations, warranties, obligations, and/or covenants set forth herein.");
        sb.append ("</br></br>FEEDBACK");
        sb.append ("</br></br>Licensee may from time to time provide suggestions, specifications, comments or other feedback to Licensor with respect to the Software (hereinafter \"Feedback\").  You agree that all Feedback is and shall be entirely voluntary and (i) shall be deemed a derivative work based on the Software, (ii) shall be owned by Licensor, and (iii) shall not create any confidentiality obligation for Licensor. However, Licensor shall not disclose the source of any Feedback without Licensee's consent.  Except as otherwise provided herein, Licensor shall be free to use such Feedback as it sees fit, entirely without obligation of any kind to Licensee.");
        sb.append ("</br></br>GOVERNING LAW; JURISDICTION AND VENUE");
        sb.append ("</br></br>This EULA shall be governed by and construed and enforced in accordance with the laws of India without reference to any conflict of law, rules or principles.  The courts in Bangalore, India will have sole jurisdiction over any disputes arising from this EULA.");
        sb.append ("</br></br>ENTIRE AGREEMENT; SEVERABILITY; NO WAIVER");
        sb.append ("</br></br>Apart from the term of use provided on the mobile platform/application domain from which this Software has been downloaded, this EULA is the entire agreement between you and the Licensor and supersedes any other prior agreements, proposals, communications or advertising, oral or written, with respect to the Product or to the subject matter of this EULA provided that the Licensor and you may limit, modify or change the applicability of the terms of this EULA by a prior, contemporaneous or subsequent written agreement and expressly providing for such limitation, modification or changes.");
        sb.append ("</br></br>You acknowledge that you have read this Agreement, understand it and agree to be bound by its terms. If any provision of this EULA is found by a court of competent jurisdiction to be invalid, void, or unenforceable for any reason, in whole or in part, such provision will be more narrowly construed so that it becomes legal and enforceable, and the entire EULA will not fail on account thereof and the balance of the EULA will continue in full force and effect to the fullest extent permitted by law. No waiver of any breach of any provisions of this EULA will constitute a waiver of any prior, concurrent or subsequent breach and no waiver will be effective unless made in writing.");
        sb.append ("</br></br>CONTACT INFORMATION");
        sb.append ("</br></br>Should you have any questions concerning this Agreement, or if you desire to contact the Licensor for any reason, please visit www.talkativeparents.com");
        sb.append ("</br></br>");
        sb.append ("</p></body></html>");
        webView.loadData (sb.toString (), "text/html", "utf-8");

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {

            case R.id.accept :
                Intent intent = new Intent(EndUserLicenceAgreement.this,MobileRegistration.class);
                startActivity(intent);
                break;

            case R.id.reject :
                finish();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
