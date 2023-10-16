import org.codevillage.Utils;
import org.codevillage.fetching.GithubDataFetcher;
import org.codevillage.fetching.SVNDataFetcher;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FetchingTests {
    @Test
    public void testGithubFetching() {
        final GithubDataFetcher githubDataFetcher = new GithubDataFetcher();
        // make dir temp
        githubDataFetcher.downloadPackage(
                "https://github.com/Fall23csc509/CodeVillage.git", "./.temp");
        final File tempFolder = new File("./.temp");
        assert (tempFolder.listFiles().length > 0);
        // delete dir temp
        try {
            Utils.deleteDirectory(tempFolder.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert(!tempFolder.exists());
    }
    @Test
    public void testSVNFetching() {
        final SVNDataFetcher svnDataFetcher = new SVNDataFetcher();
        // make dir temp
        final String cwd = System.getProperty("user.dir");
        svnDataFetcher.downloadPackage(
                String.format("file://%s/src/test/resources/svn_test_repo", cwd), "./.temp"
        );
        final File tempFolder = new File("./.temp");
        assert (tempFolder.listFiles().length > 0);
        // delete dir temp
        try {
            Utils.deleteDirectory(tempFolder.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert(!tempFolder.exists());
    }
}